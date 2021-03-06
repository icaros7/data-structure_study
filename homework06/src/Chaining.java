/*
 * 과제: homework06
 * 작성: 201735030 이호민
 * 파일: Chaining.java
 */

public class Chaining <K, V> {
    private int M = 13; // 테이블 크기
    private Node[] a = new Node[M]; // 해시 테이블

    // 내부 사용 Node 클래스
    public static class Node {
        private Object key;
        private Object data;
        private Node next;

        public Node(Object newKey, Object newData, Node ref) {
            key = newKey;
            data = newData;
            next = ref;
        }

        public Object getKey() { return key; }
        public Object getData() { return data; }
    }

    // 해시 테이블 출력 메서드
    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print(i);
            printData(a[i]);
            System.out.println();
        }
    }

    private void printData(Node n) {
        if (n != null) {
            System.out.print("-->[" + n.getKey() + ", " + n.getData() + "]");
            printData(n.next);
        }
        else return;
    }

    // 나눗셈 연산 메서드
    private int hash(K key) { return ((key.hashCode() & 0x7fffffff) % M); }

    // 탐색 연산 메서드
    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) { if (key.equals(x.key)) { return (V) x.data; } } // 탐색 성공시

        return null; // 탐색 실패시
    }

    // 탐색 정보 출력 메서드
    public void getPrint(K key) {
        System.out.println(key + "의 data = " + get(key));
    }

    // 삽입 연산 메서드
    public void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) { // 이미 key 가 있는 경우
                x.data = data; // 데이터만 갱신
                return;
            }
        }

        a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입
    }
}
