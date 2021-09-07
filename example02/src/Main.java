/*
 * 과제: homework02
 * 이름: 이호민
 * 학번: 201735030
 */

public class Main {
    public static void main(String[] args) {
        // 새 연결 리스트 객체 s 생성
        SList<String> s = new SList<String>(); // 의도적 타입 지정
        s.insertFront("Orange");
        s.insertFront("Apple");
        s.insertAfter("Cherry", s.head.getNext());
        s.insertFront("Pear");

        s.print();
        System.out.println(": s의 길이 = " + s.size() + "\n");
        System.out.println("체리가 \t" + s.search("Cherry") + "번째에 있다.");
        System.out.println("키위가 \t" + s.search("Kiwi") + "번째에 있다.");
        s.deleteAfter(s.head);
        s.print();
        System.out.println(": s의 길이 = " + s.size() + "\n");
        s.deleteFront();
        System.out.println(": s의 길이 = " + s.size() + "\n");

        // 새 연결 리스트 객체 t 생성
        SList<Integer> t = new SList<Integer>(); // 의도적 타입 지정
        t.insertFront(500);
        t.insertFront(200);
        t.insertAfter(400, t.head);
        t.insertFront(100);
        t.insertAfter(300, t.head.getNext());
        t.print();
        System.out.println(": t의 길이 = " + t.size());
    }
}