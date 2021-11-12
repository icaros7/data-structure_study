/*
 * 과제: homework07
 * 작성: 201735030 이호민
 * 파일: Main.java
 */

public class Main {
    public static void main(String[] args) {
        Entry[] entry = new Entry[7]; // a[0]은 사용 안함

        // 문자 입력
        entry[1] = new Entry(60, "a", null, null, null);
        entry[2] = new Entry(20, "b", null, null, null);
        entry[3] = new Entry(30, "c", null, null, null);
        entry[4] = new Entry(35, "d", null, null, null);
        entry[5] = new Entry(40, "e", null, null, null);
        entry[6] = new Entry(90, "f", null, null, null);

        Huffman huffman = new Huffman(entry, 6);
        System.out.println("최소힙 만들기 전:");
        huffman.print();

        huffman.createHeap();
        System.out.println("최소 힙:");
        huffman.print();

        int[] arr = new int[huffman.getSize() - 1];
        System.out.println("허프만 코드:");
        Entry root = huffman.createTree();
        huffman.preOrder(root, arr, 0);
    }
}
