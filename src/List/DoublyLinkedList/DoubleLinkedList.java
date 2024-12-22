package List.DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E>{

  private final Node<E> head;
  private final Node<E> tail;
  private int size;

  public DoubleLinkedList() {
    head = new Node<>(null, null, null);
    tail = new Node<>(null, head, null);
    head.setNext(tail);
    size = 0;
  }

  // 노드 p 앞에 삽입
  public void insertBefore(Node<E> p, E newItem) {
    if (p == null || p == head) throw new IllegalArgumentException("Invalid node position.");
    Node<E> newNode = new Node<>(newItem, p.getPrev(), p);
    p.getPrev().setNext(newNode);
    p.setPrev(newNode);
    size++;
  }

  // 노드 x 삭제
  public void delete(Node<E> x) {
    if (x == null || x == head || x == tail)
      throw new NoSuchElementException("Cannot delete invalid node.");
    x.getPrev().setNext(x.getNext());
    x.getNext().setPrev(x.getPrev());
    size--;
  }

  // 리스트 출력
  public void printList() {
    Node<E> current = head.getNext();
    while (current != tail) {
      System.out.print(current.getItem() + " <-> ");
      current = current.getNext();
    }
    System.out.println("null");
  }
}
