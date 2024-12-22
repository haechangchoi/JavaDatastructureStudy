package List.CircularLinkedList;

import java.util.NoSuchElementException;

//last 포인터만을 사용해 구현

public class CircularLinkedList <E> {

  private Node<E> last; // 리스트의 마지막 노드를 가리킴
  private int size;     // 현재 리스트의 크기(노드 개수)

  // 생성자: 빈 리스트 초기화
  public CircularLinkedList() {
    last = null;
    size = 0;
  }

  // 노드를 삽입: 리스트의 맨 앞에 삽입됨
  public void insert(E newItem){
    Node<E> newNode = new Node<>(newItem, null); // 새 노드 생성

    if (isEmpty()) { // 리스트가 비어있으면
      newNode.setNext(newNode); // 자기 자신을 가리키도록 설정, 원형이기 때문이다.
      last = newNode;           // last 포인터를 새 노드로 설정
    } else {
      newNode.setNext(last.getNext()); // 새 노드가 첫 번째 노드를 가리키게 설정, 원형이니까 마지막 last의 다음 노드가 첫 번재
      last.setNext(newNode);           // 마지막 노드가 새 노드를 가리키도록 설정
      last = newNode; // 마지막 노드를 새 노드로 갱신
    }
    size++; // 리스트 크기 증가
  }

  // 노드를 삭제: 삭제된 노드를 반환
  public Node<E> delete() {
    if (isEmpty()) {
      throw new NoSuchElementException("List is empty!"); // 리스트가 비어있으면 예외 발생
    }

    Node<E> first = last.getNext(); // 첫 번째 노드 참조

    if (first == last) { // 노드가 하나만 있는 경우
      last = null; // 리스트를 비움
    } else {
      last.setNext(first.getNext()); // 첫 번째 노드를 건너뛰고 두 번째 노드를 가리킴
      first.setNext(null); // 삭제된 노드의 링크를 끊음
    }

    size--; // 리스트 크기 감소
    return first; // 삭제된 노드 반환
  }

  // 리스트가 비어있는지 확인
  public boolean isEmpty() {
    return last == null;
  }

  // 리스트 크기 반환
  public int size() {
    return size;
  }

  // 원형 리스트 출력
  public void printList() {
    if (isEmpty()) {
      System.out.println("List is empty!");
      return;
    }

    Node<E> current = last.getNext(); // 첫 번째 노드부터 시작

    do {
      System.out.print(current.getItem() + " -> "); // 현재 노드 출력
      current = current.getNext(); // 다음 노드로 이동
    } while (current != last.getNext()); // 다시 첫 노드에 도달하면 종료

    System.out.println("(Back to start)"); // 원형 리스트 순환 표시
  }
}
