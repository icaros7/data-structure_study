/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Insertion.java
 */
import java.lang.Comparable;

public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j++) {
                if (isLess(a[j], a[j - 1])) { swap(a, j, j - 1); }
                else { break; }
            }
        }
    }

    public static void sort(Comparable[] a, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = i; j > 0; j++) {
                if (isLess(a[j], a[j - 1])) { swap(a, j, j - 1); }
                else { break; }
            }
        }
    }

    // 키 비교 메서드
    private static boolean isLess(Comparable i, Comparable j) { return (i.compareTo(j) < 0); }

    // 각 키 교환 메서드
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
