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
         * 요구조건 하드 코딩
         * 리스트 1: 1 -> 4 -> 5 -> 8
         * 리스트 2: 2 -> 3 -> 5 -> 7 -> 9
         */

        s1.insertFront(1);
        s1.insertAfter(4, s1.endN);
        s1.insertAfter(5, s1.endN);
        s1.insertAfter(8, s1.endN);

        s2.insertFront(2);
        s2.insertAfter(3, s2.endN);
        s2.insertAfter(5, s2.endN);
        s2.insertAfter(7, s2.endN);
        s2.insertAfter(9, s2.endN);

        // 각각 리스트 사전 출력
        s1.print(1);
        s2.print(2);
        System.out.println();

        // s1 SList 를 Master 로 하여 s2 SList 와 병합
        SList merged = s1.merge(s2);

        // merged SList 출력
        merged.print(0);
    }
}
