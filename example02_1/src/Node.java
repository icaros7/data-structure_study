/*
 * 주제: Singly Linked List
 * 이름: 이호민
 * 학번: 201735030
 */

public class Node <E>{
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> node){
        item = newItem;
        next = node;
    }

    // get & get 메서드
    public E getItem(){ return item; }
    public Node<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setNext(Node<E> newNext) { next = newNext; }
}
