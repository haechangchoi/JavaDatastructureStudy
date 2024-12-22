package List.SinglyLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList <E extends Comparable<E>> {

  private Node<E> head; // 리스트의 첫 번째 노드를 가리킴
  private int size;  // 리스트 크기

  // 기본 생성자: 빈 리스트 초기화
  public SinglyLinkedList() {
    head = null;
    size = 0;
  }

  // 리스트 맨 앞에 삽입
  public void insertFront(E newItem) {
    head = new Node<>(newItem, head);
    size++;
  }

  // 특정 노드 p 다음에 삽입
  public void insertAfter(Node<E> p, E newItem) {
    if (p == null) throw new IllegalArgumentException("Node cannot be null.");
    p.setNext(new Node<>(newItem, p.getNext()));
    size++;
  }

  public void deleteFront() {
    head = head.getNext();
    size--;
  }

  // 특정 노드 p 다음 노드 삭제
  public E deleteAfter(Node<E> p) {
    if (p == null || p.getNext() == null)
      throw new NoSuchElementException("Invalid node or next node is null!");
    Node<E> target = p.getNext();
    E item = target.getItem();
    p.setNext(target.getNext());
    size--;
    return item;
  }

  // 대상 아이템 검색 (인덱스 반환)
  public int search(E target) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.getItem().compareTo(target) == 0) return i;
      current = current.getNext();
    }
    return -1; // 찾지 못했을 때
  }

  // 리스트가 비었는지 확인
  public boolean isEmpty() {
    return head == null;
  }

  // 리스트 크기 반환
  public int size() {
    return size;
  }

  // 리스트 출력
  public void printList() {
    Node<E> current = head;
    while (current != null) {
      System.out.print(current.getItem() + " -> ");
      current = current.getNext();
    }
    System.out.println("null");
  }

}
