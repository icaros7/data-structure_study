/*
 * 과제: homework08
 * 작성: 201735030 이호민
 * 파일: Heap.java
 */
import java.lang.Comparable;

public class Heap {
    // 정렬 메서드
    public static void sort(Comparable[] a) {
        int heapSize = a.length - 1; // a[0]은 사용 안함
        for (int i = heapSize / 2; i > 0; i--) { downHeap(a, i, heapSize); } // 힙 생성
        while (heapSize > 1) {
            swap(a, 1, heapSize--); // 힙 정렬
            downHeap(a, 1, heapSize); // 위배된 힙 속성 고치기
        }
    }

    // 위배된 힙 속성 탐색 및 수정 메서드
    private static void downHeap(Comparable[] a, int p, int heapSize) {
        while (2 * p <= heapSize) {
            int s = 2 * p; // s = 왼쪽 자식의 인덱스
            if (s < heapSize && isLess(a[s], a[s + 1])) { s++; } // 오른쪽 자식이 큰 경우
            if (!isLess(a[p], a[s])) { break; } // 힙 속성을 만족 시

            swap(a, p, s); // 힙 속성 불만족시 부모(p)와 자식 승자 (s) Swap
            p = s; // 이제 자식 승자 자리에 부모를 넣어줌
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
