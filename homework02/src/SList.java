/*
 * 과제: homework02
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.NoSuchElementException;

public class SList<E> {
    protected Node head; // 연결 리스트의 첫 노드 가리킴
    protected Node endN; // 연결 리스트의 마지막 노드를 가리킴
    private int size; // 연결 리스트의 사이즈

    // 연결 리스트 생성자
    public SList(){
        head = null;
        endN = null;
        size = 0;
    }

    // 출력 메서드
    public void print(int list){
        Node c = head; // Node c: 출력할 위치를 저장할 임시 Cursor Node

        String s = (list == 1) ? "리스트1" : (list == 2) ? "리스트2" : "통합 리스트";
        System.out.print(s + ": ");

        for (int k = 0; k < size; k++){
            if (k != size - 1)  { System.out.print(c.getItem() + " -> "); }
            else { System.out.print(c.getItem() + "\n"); }
            c = c.getNext();
        }
    }

    // size 값 반환 메서드
    public int size(){ return this.size; }

    // this 와 slaveList 를 merge 하여 반환하는 메서드
    public SList merge(SList slaveList) {
        // 빈 리스트의 경우 사전 검사
        if (this.size() == 0 && slaveList.size() != 0) { return slaveList; }
        else if (slaveList.size() == 0 && this.size() != 0) { return this; }
        else if (this.size() == 0 && slaveList.size() == 0) { return null; }

        // Merge 될 새로운 SList 생성
        SList newList = new SList<Integer>();

        // 각각 Cursor 용 Node 생성
        Node master = head;
        Node slave = slaveList.head;

        for (int k = 0; k < biggerSize(size(), slaveList.size()); k++) { // 더 큰 리스트의 Size 만큼 for 문 동작
            // 한쪽 리스트가 끝나는 경우, 다른 리스트 요소만 순차 추가
            if (master == null || slave == null) {
                if (size() > slaveList.size()) {
                    newList.insertAfter(master.getItem(), newList.endN);
                    master.getNext();
                }
                else {
                    newList.insertAfter(slave.getItem(), newList.endN);
                    slave.getNext();
                }
                continue;
            }

            // getItem 의 Int 값에 따라 순차 추가
            if ((int)master.getItem() > (int)slave.getItem()) {
                if (k == 0) { newList.insertFront(slave.getItem());
                }
                else { newList.insertAfter(slave.getItem(), newList.endN);
                }
                newList.insertAfter(master.getItem(), newList.endN);
            }
            else if ((int)master.getItem() < (int)slave.getItem()) {
                if (k == 0) { newList.insertFront(master.getItem());
                }
                else {
                    newList.insertAfter(master.getItem(), newList.endN);
                }
                newList.insertAfter(slave.getItem(), newList.endN);
            }
            else {
                if (k == 0) { newList.insertFront(master.getItem()); }
                else { newList.insertAfter(master.getItem(), newList.endN); newList.insertAfter(slave.getItem(), newList.endN); }
            }

            // 각각 커서를 다음 위치로 이동
            master = master.getNext();
            slave = slave.getNext();
        }

        return newList;
    }

    // target 탐색하는 메서드
    public int search(E target){
        Node p = head;

        for (int k = 0; k < size; k++){
            if (target == p.getItem()) { return k; }
            p = p.getNext();
        }

        // 탐색 실패 시 -1 return
        return -1;
    }

    // 가장 앞에 새 노드 삽입
    public void insertFront(E newItem){
        head = new Node(newItem, head);
        endN = head;
        size++;
    }

    // 노드 p 바로 다음에 새 노드 삽입
    public void insertAfter(E newItem, Node p){
        Node t = new Node(newItem, p.getNext());
        p.setNext(t);
        endN = t;
        size++;
    }

    // 리스트의 첫 노드 삭제
    public void deleteFront(){
        if (size == 0) throw new NoSuchElementException();
        head = head.getNext(); // 추후 gc로 인하여 수거 예정
        size--;
    }

    // p가 가르키는 노드의 다음 노드를 삭제
    public void deleteAfter(Node p){
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null); // 추후 gc로 인하여 수거 예정
        size--;
    }

    // 리스트 사이즈 비교 메서드
    private int biggerSize(int s1, int s2) { return Math.max(s1, s2); }
}