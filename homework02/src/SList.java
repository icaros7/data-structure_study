import java.util.NoSuchElementException;

public class SList <E> {
    protected Node head; // 연결 리스트의 첫 노드 가리킴
    private int size;

    // 연결 리스트 생성자
    public SList(){
        head = null;
        size = 0;
    }

    // 출력 메소드
    public void print(){
        Node c = head;
        for (int k = 0; k < size; k++){
            System.out.println(c.getItem());
            c = head.getNext();
        }
    }

    // size 값 반환 메소드
    public int size(){ return this.size; }

    // target 탐색하는 메소드
    public int search(E target){
        Node p = head;

        for (int k = 0; k < size; k++){
            if (target == p.getItem()) { return k; }
            p = p.getNext();
        }

        // 탐색 실패 시 -1 return
        return -1;
    }

    // 가장 앞에 새 노드 삽입
    public void insertFront(E newItem){
        head = new Node(newItem, head);
        size++;
    }

    // 노드 p 바로 다음에 새 노드 삽입
    public void insertAfter(E newItem, Node p){
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    // 리스트의 첫 노드 삭제
    public void deleteFront(){
        if (size == 0) throw new NoSuchElementException();
        head = head.getNext(); // 추후 gc로 인하여 수거 예정
        size--;
    }

    // p가 가르키는 노드의 다음 노드를 삭제
    public void deleteAfter(Node p){
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null); // 추후 gc로 인하여 수거 예정
        size--;
    }
}
