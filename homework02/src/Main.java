/*
 * 과제: homework02
 * 이름: 이호민
 * 학번: 201735030
 */

public class Main {
    public static void main(String[] args) {
        // 새 연결 리스트 객체 s1, s2 생성
        SList s1 = new SList<Integer>();
        SList s2 = new SList<Integer>();

        /*
         * 요구조건 반영
         * 리스트 1: 1 -> 4 -> 5 -> 8
         * 리스트 2: 2 -> 3 -> 5 -> 7 -> 9
         */

        s1.insertFront(8);
        s1.insertFront(5);
        s1.insertFront(4);
        s1.insertFront(1);

        s2.insertFront(9);
        s2.insertFront(7);
        s2.insertFront(5);
        s2.insertFront(3);
        s2.insertFront(2);

        s1.print(1);
        s2.print(2);

        SList merged = s1.merge(s2);
        merged.print(0);
    }
}
