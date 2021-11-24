/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Merge.java
 */
import java.lang.Comparable;

public class Merge {
    private static int callSize = 10;

    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) { b[k] = a[j++]; }                 // 앞부분 선 소진 시
            else if (j > high) { b[k] = a[i++]; }           // 뒷부분 선 소진 시
            else if (isLess(a[j], a[i])) { b[k] = a[j++]; } // a[j]가 승자
            else { b[k] = a[i++]; }                         // a[i]가 승자
        }
    }

    // 정렬 메서드
    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
        // if (high <= low) { return; }
        if (high < low + callSize) {
            Insertion.sort(a, low, high);
            return;
        }

        int mid = low + (high - low) / 2;
        sort(a, b, low, mid);           // 앞부분 재귀
        sort(a, b, mid + 1, high);      // 뒷부분 재귀
        if (!isLess(a[mid + 1], a[mid])) { return; }
        merge(a, b, low, mid, high);    // 합병
    }

    // 키 비교 메서드
    private static boolean isLess(Comparable v, Comparable w) { return (v.compareTo(w) < 0); }
}
