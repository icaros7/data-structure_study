/*
 * 과제: homework07
 * 작성: 201735030 이호민
 * 파일: Huffman.java
 */

public class Huffman {
    private Entry[] a;      // a[0]은 사용 안함
    private int N;          // 힙의 크기

    // 생성자
    public Huffman(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }

    // 빈도수 비교 메서드
    private boolean greater(int i, int j) { return a[i].getKey() > a[j].getKey(); }

    // 두 Entry 스왑 메서드
    private void swap(int i, int j) {
        Entry tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 부모 자식 교환 메서드
    private void downHeap(int i) {      // i는 현재 노드의 인덱스
        while (2 * i <= N) {            // i의 왼쪽 자식노드가 힙에 있으면
            int k = 2 * i;              // k는 왼쪽 자식노드의 인덱스

            if (k < N && greater(k, k + 1)) { k++; } // k가 승자의 인덱스가 됨
            if (!greater(i, k)) { break; }              // 현재 노드가 자식 승자와 같거나 작으면 탈출

            swap(i, k);                 // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자 교환
            i = k;                      // 자식 승자가 현재 노드가 되어 다시 반복 준비
        }
    }

    // 자식 부모 교환 메서드
    private void upHeap(int j) {
        while (j > 1 && greater(j/2, j)) {
            swap(j/2, j);
            j = j / 2;
        }
    }

    // 허프만 코드 배열 출력 메서드
    private void printArr(int[] arr, int cur) {
        for(int i = 0; i < cur; i++) { System.out.print(arr[i]); }
        System.out.print("  ");
    }

    // 삽입 메서드
    public void insert(int freq, String val, Entry l, Entry r, String s) {
        Entry temp = new Entry(freq, val, l, r, s); // Entry 생성
        a[++N] = temp;                              // 새로운 키를 배열 마지막 항목 다음에 저장
        upHeap(N);                                  // 위로 올라가며 힙속성 회복 준비
    }

    // 힙 생성 메서드
    public void createHeap() { for(int i = N/2; i > 0; i--) { downHeap(i); } }

    // 최소값 제거 메서드
    public Entry deleteMin() {
        Entry min = a[1];
        swap(1, N--);
        a[N + 1] = null;
        downHeap(1);

        return min;
    }

    // 트리 생성 메서드
    public Entry createTree() {
        while (getSize() > 1) {     // 힙에 1개의 노드만 남을 떄 까지
            Entry e1 = deleteMin(); // 힙에서 최소 빈도 수 가진 노드를 제거하여 e1이 참조
            Entry e2 = deleteMin(); // 힙에서 최소 빈도 수 가진 노드를 제거하여 e2가 참조
            Entry temp = new Entry(e1.getKey() + e2.getKey(), e1.getValue() + e2.getKey(), e1, e2, " ");
            insert(temp);
        }

        return deleteMin(); // 루트노드를 힙에서 제거하며 리턴
    }

    // 전위 순회하며 허프만 코드 출력 메서드
    public void preOrder(Entry entry, int[] arr, int cur) {
        if (entry.getLeft() != null) {
            arr[cur] = 0; // left 이동시 배열에 0 추가
            preOrder(entry.getLeft(), arr, cur + 1);
        }
        if (entry.getRight() != null) {
            arr[cur] = 1; // right 이동시 배열에 1 추가
            preOrder(entry.getRight(), arr, cur + 1);
        }
        if (entry.getRight() == null && entry.getLeft() == null) {
            System.out.print(entry.getValue() + ": ");
            printArr(arr, cur);
        }
    }

    // Entry 배열 출력 메서드
    public void print() {
        for (int i = 1; i < N; i++) { System.out.print("[" + a[i].getKey() + " " + a[i].getValue() + "] "); }
        System.out.println();
    }
}
