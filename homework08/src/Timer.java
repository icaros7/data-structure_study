/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Timer.java
 */

public class Timer {
    private static long start, end;
    private static long calcTimer() { return end - start; }
    private static void endTimer() { end = System.currentTimeMillis(); }

    public static void startTimer() { start = System.currentTimeMillis(); }
    public static void printTimer(String s) {
        endTimer();
        System.out.println("\n" + s + " 정렬의 결과: 소요 시간 " + calcTimer() + "ms");
    }
}
