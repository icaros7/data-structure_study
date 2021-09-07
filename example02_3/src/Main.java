/*
 * 주제: Circular Linked List
 * 이름: 이호민
 * 학번: 201735030
 */

public class Main {
    public static void main(String[] args) {
        // 연결 리스트 객체 s 생성 및 의도적 타입 지정
        CList<String> s = new CList<String>();

        s.insert("Pear");
        s.insert("Cherry");
        s.insert("Orange");
        s.insert("Apple");
        s.print();
        System.out.print(": s의 길이 = " + s.size() + "\n");

        s.delete();
        s.print();
        System.out.print(": s의 길이 = " + s.size() + "\n");
    }
}
