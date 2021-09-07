/*
 * 주제: Doubly Linked List
 * 이름: 이호민
 * 학번: 201735030
 */

public class Main {
    public static void main(String[] args){
        // 이중 연결 리스트 객체 s 생성 및 의도적 타입 명시
        DList<String> s = new DList<String>();

        s.insertAfter(s.head, "Apple");
        s.insertBefore(s.tail, "Orange");
        s.insertBefore(s.tail, "Cherry");
        s.insertAfter(s.head.getNext(), "Pear");
        s.print();
        System.out.println();

        s.delete(s.tail.getPrevious());
        s.print();
        System.out.println();

        s.insertBefore(s.tail, "Grape");
        s.print();
        System.out.println();

        s.delete(s.head.getNext());
        s.print();
        s.delete(s.head.getNext());
        s.print();
        s.delete(s.head.getNext());
        s.print();
        s.delete(s.head.getNext());
    }
}
