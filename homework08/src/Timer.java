/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Timer.java
 */

public class Timer {
    private static long start, end; // 현재 시간 기록용 long 변수
    private static long calcTimer() { return end - start; } // 소요 시간 계산 메서드
    private static void endTimer() { end = System.currentTimeMillis(); } // 종료 시간 기록 메서드

    public static void startTimer() { start = System.currentTimeMillis(); } // 시작 시간 기록 메서드
    public static void printTimer(String s) { // 소요 시간 출력 메서드
        endTimer();
        System.out.println("\n" + s + " 정렬의 결과: 소요 시간 " + calcTimer() + "ms");
    }
}
