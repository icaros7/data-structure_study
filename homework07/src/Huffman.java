/*
 * 과제: homework07
 * 작성: 201735030 이호민
 * 파일: Huffman.java
 */

public class Huffman {
    private Entry[] a;      // a[0]은 사용 안함
    private int N;          // 힙의 크기

    public Huffman(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }

    private boolean greater(int i, int j) { return a[i].getKey() > a[j].getKey(); }

    private void swap(int i, int j) {
        Entry tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void downHeap(int i) {      // i는 현재 노드의 인덱스
        while (2 * i <= N) {            // i의 왼쪽 자식노드가 힙에 있으면
            int k = 2 * i;              // k는 왼쪽 자식노드의 인덱스

            if (k < N && greater(k, k + 1)) { k++; } // k가 승자의 인덱스가 됨
            if (!greater(i, k)) { break; }              // 현재 노드가 자식 승자와 같거나 작으면 탈출

            swap(i, k);                 // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자 교환
            i = k;                      // 자식 승자가 현재 노드가 되어 다시 반복 준비
        }
    }

    private void upHeap(int j) {
        while (j > 1 && greater(j/2, j)) {
            swap(j/2, j);
            j = j / 2;
        }
    }

    public void insert(int freq, String val, Entry l, Entry r, String s) {
        Entry temp = new Entry(freq, val, l, r, s); // Entry 생성
        a[++N] = temp;                              // 새로운 키를 배열 마지막 항목 다음에 저장
        upHeap(N);                                  // 위로 올라가며 힙속성 회복 준비
    }

    public void createHeap() { for(int i = N/2; i > 0; i--) { downHeap(i); } }

    public Entry deleteMin() {
        Entry min = a[1];
        swap(1, N--);
        a[N + 1] = null;
        downHeap(1);

        return min;
    }
}
