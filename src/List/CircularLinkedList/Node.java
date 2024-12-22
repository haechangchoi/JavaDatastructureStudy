package List.CircularLinkedList;

public class Node<E> {

  private final E item;      // 노드의 데이터
  private Node<E> next; // 다음 노드를 가리킴

  // 생성자: 데이터와 다음 노드 설정
  public Node(E item, Node<E> next) {
    this.item = item;
    this.next = next;
  }

  // 데이터 반환
  public E getItem() {
    return item;
  }

  // 다음 노드 반환
  public Node<E> getNext() {
    return next;
  }

  // 다음 노드 설정
  public void setNext(Node<E> next) {
    this.next = next;
  }
}
