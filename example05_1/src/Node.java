/*
 * Example: 05_1
 * 학번: 201735030
 * 이름: 이호민
 * 파일: Node.java
 */

public class Node <Key extends Comparable<Key>, Value> {
    Key id;
    Value name;
    Node left, right;

    public Node(Key newId, Value newName) {
        id = newId;
        name = newName;
        left = right = null;
    }

    // getter
    public Key getKey() { return id; }
    public Value getValue() { return name; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }

    // setter
    public void setKey(Key newId) { this.id = newId; }
    public void setValue(Value newName) { this.name = newName; }
    public void setLeft(Node newLeft) { this.left = newLeft; }
    public void setRight(Node newRight) { this.right = newRight; }
}
