/*
 * 과제: homework06
 * 작성: 201735030 이호민
 * 파일: Main.java
 */

public class Main {
    public static void main(String[] args) {
        Chaining c = new Chaining(); // 새로운 해시 테이블 생성

        // 지정된 값과 아이템 삽입
        c.put(25, "Grape");
        c.put(37, "Apple");
        c.put(18, "Banana");
        c.put(55, "Cherry");
        c.put(22, "Mango");
        c.put(35, "Lemon");
        c.put(50, "Orange");
        c.put(63, "Watermelon");

        // 일부 값 탐색
        System.out.println("탐색 결과");
        c.getPrint(50);
        c.getPrint(63);
        c.getPrint(37);
        c.getPrint(22);

        // 해시 테이블 내용 출력
        System.out.println("\n해시 테이블");
        c.printTable();
    }
}
