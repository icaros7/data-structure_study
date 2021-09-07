/*
 * 주제: Doubly Linked List
 * 이름: 이호민
 * 학번: 201735030
 */

import java.util.NoSuchElementException;

public class DList <E> {
    protected DNode head, tail;
    protected int size;

    // DList 생성자
    public DList() {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null); // head 를 previous 로 가르키는 tail 노드 생성
        head.setNext(tail); // head 노드의 다음 노드를 tail 노드로 set
        size = 0;
    }

    // p가 가리키는 노드 앞에 삽입
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    // p가 가리키는 노드 뒤에 삽입
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        p.setNext(newNode);
        t.setPrevious(newNode);
        size++;
    }

    // x가 가리키는 노드 삭제
    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--; // 이후 x는 gc에 의해 자동 수거

        if (size == 0){ System.out.println("리스트 비어있음"); }
   }

    public void print() {
        DNode c = head.getNext();
        for (int k = 0; k < size; k++) {
            System.out.print(c.getItem() + "\t");
            c = c.getNext();
        }
        System.out.print("\n");
    }
}
