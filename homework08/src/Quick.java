/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Quick.java
 */
import java.lang.Comparable;

public class Quick {
    private static int callSize = 10;
    public static void sort(Comparable[] a) { sort(a, 0, a.length - 1); }

    private static void sort(Comparable[] a, int low, int high) {
        // if (high <= low) { return; }
        if (high < low + callSize) {
            Insertion.sort(a, low, high);
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀
        sort(a, j + 1, high); // 피벗보다 큰 부분을 재귀
    }

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        Comparable p = a[pivot];

        while (true) {
            while (isLess(a[++i], p)) { if (i == high) { break; } } // 피벗보다 작을 경우 탈출
            while (isLess(p, a[--j])) { if (j == pivot) { break; } }// 피벗보다 클 경우 탈출
            if (i >= j) { break; }                                  // i와 j가 교차 되면 탈출
            swap(a, i, j);
        }

        swap(a, pivot, j);  // 피벗과 a[j] 교환
        return j;           // a[j]의 피벗이 "영원히" 자리 잡은 곳
    }

    // 키 비교 메서드
    private static boolean isLess(Comparable u, Comparable v) { return (u.compareTo(v) < 0); }

    // 각 키 교환 메서드
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
