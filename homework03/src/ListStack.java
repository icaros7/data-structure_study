/*
 * 과제: homework03
 * 이름: 이호민
 * 학번: 201735030
 */
import java.util.EmptyStackException;

public class ListStack <E> {
    private Node<E> top;    // 스택 top 항목을 가진 Node
    private int size;       // 스택의 항목 수

    // 생성자
    public ListStack() {
        top = null;
        size = 0;
    }

    // 스택 size 값 return
    public int size() { return size; }

    // 스택이 비었다면 true return
    public boolean isEmpty() { return size == 0; }

    // 스택의 top 항목을 리턴
    public E peek() {
        if (isEmpty()) { throw new EmptyStackException(); } // underflow 시 프로세스 중단
        return top.getItem();
    }

    // 스택 push 연산
    public void push(E newItem) {
        Node newNode = new Node(newItem, top); // 노드 앞 부분에 삽입
        top = newNode;
        size++;
    }

    // 스택 pop 연산
    public E pop() {
        if (isEmpty()) { throw new EmptyStackException(); } // underflow 시 프로세스 중단
        E topItem = top.getItem();                      // 스택 top 항목을 topItem에 저장
        top = top.getNext();                            // top이 top 바로 아래 항목을 가리킴
        size--;                                         // 스택 수 1 감소
        return topItem;
    }
}
