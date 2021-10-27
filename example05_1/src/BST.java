/*
 * Example: 05_1
 * 학번: 201735030
 * 이름: 이호민
 * 파일: BST.java
 */

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;

    public Node getRoot() { return root; } // root getter

    public BST (Key newId, Value newName) {
        root = new Node(newId, newName);
    }

    // 검색 연산
    public Value get(Key k) { return get(root, k); }
    public Value get(Node n, Key k) {
        if (n == null) { return null; } // k를 발견하지 못함

        int t = n.getKey().compareTo(k); // k와 노드의 Key(Id)를 비교한 결과에 따라
        if (t > 0) { return get(n.getLeft(), k); }
        else if (t < 0) { return get(n.getRight(), k); }
        else return (Value) n.getValue();
    }

    // 삽입 연산
    public void put(Key k, Value v) { root = put(root, k, v); }
    public Node put(Node n, Key k, Value v) {
        if (n == null) { return new Node(k, v); }

        int t = n.getKey().compareTo(k); // k와 노드의 Key(Id)를 비교한 결과에 따라
        if (t > 0) { n.setLeft(put(n.getLeft(), k, v)); }
        else if (t < 0) { n.setRight(put(n.getRight(), k, v)); }
        else n.setValue(v);

        return n;
    }

    // 최소값 검색 연산
    public Key min() {
        if (root == null) { return null; }
        return (Key) min(root).getKey();
    }
    public Node min(Node n) {
        if (n.getLeft() == null) { return n; }
        return min(n.getLeft());
    }

    // 최소값 삭제 연산
    public void deleteMin() {
        if (root == null) { System.out.println("empty 트리"); }
        root = deleteMin(root);
    }
    public Node deleteMin(Node n) {
        if (n.getLeft() == null) { return n.getRight(); }
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    // 삭제 연산
    public void delete(Key k) { root = delete(root, k); }
    public Node delete(Node n, Key k) {
        if (n == null) { return null; }

        int t = n.getKey().compareTo(k);
        if (t > 0) { n.setLeft(delete(n.getLeft(), k)); } // k < 노드n의 id, 왼쪽 자식 이동
        else if (t < 0) { n.setRight(delete(n.getRight(), k)); } // k > 노드n의 id, 오른쪽 자식 이동

        else { // 삭제 할 노드 발견 시
            if (n.getRight() == null) { return n.getLeft(); } // case 0, 1
            if (n.getLeft() == null) { return n.getRight(); } // case 1

            Node target = n; // case 2 Line10-13
            n = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드 찾아서 n을 가리키게 함
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }

        return n;
    }
}
