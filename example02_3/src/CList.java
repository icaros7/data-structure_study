/*
 * 주제: Circular Linked List
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.NoSuchElementException;

public class CList <E> {
    private Node last;
    private int size;

    // 리스트 생성자
    public CList() {
        last = null;
        size = 0;
    }

    // 리스트가 비어 있는지 확인하는 메서드
    private boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    // size 반환 메서드
    public int size() {
        return this.size;
    }

    // 리스트 출력 메서드
    public void print() {
        if (isEmpty()) { System.out.println("리스트가 비어있음"); }
        else {
            Node c = last.getNext();
            for (int k = 0; k < size; k++) {
                System.out.print(c.getItem() + "\t");
                c = c.getNext();
            }
        }
    }

    // last가 가리키는 노드의 다음에 새 노드 삽입
    public void insert(E newItem) {
        Node newNode = new Node(newItem, null);

        // 리스트가 empty 일 때
        if (last == null) {
            newNode.setNext(newNode);
            last = newNode;
        }
        else {
            newNode.setNext(last.getNext()); // newNode의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록 설정
            last.setNext(newNode);
        }
        size++;
    }

    // last가 가리키는 노드의 다음 노드를 제거
    public Node delete() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = last.getNext(); // x가 리스트의 첫 노드를 가리킴

        if (x == last) { last = null; } // 리스트에 1개의 노드만 있는 경우
        else {
            last.setNext(x.getNext()); // last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록 설정
            x.setNext(null); // 추후 gc에 의해 자동 수거
        }
        size--;
        return x;
    }
}
