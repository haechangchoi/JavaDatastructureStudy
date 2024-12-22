package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

  private E[] queue;    // 큐를 저장하는 배열
  private int front;    // 첫 번째 요소의 인덱스
  private int rear;     // 마지막 요소의 인덱스
  private int size;     // 현재 큐의 요소 개수

  // 초기 큐 크기는 10으로 설정
  public ArrayQueue() {
    queue = (E[]) new Object[10];
    front = 0;
    rear = 0;
    size = 0;
  }

  // 현재 큐에 저장된 요소 개수 반환
  public int size() {
    return size;
  }

  // 큐가 비어있는지 확인
  public boolean isEmpty() {
    return size == 0;
  }

  // 요소를 큐에 추가
  public void add(E newItem) {
    if (size == queue.length) {  // 큐가 가득 차면 크기 증가
      resize(2 * queue.length);
    }
    queue[rear] = newItem;          // rear 위치에 새 요소 추가
    rear = (rear + 1) % queue.length; // rear 위치 갱신 (순환 큐)
    size++;
  }

  // 큐에서 요소를 제거하고 반환
  public E remove() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    E removedItem = queue[front];     // front 위치의 요소를 제거
    queue[front] = null;              // 메모리 누수를 방지하기 위해 null로 설정
    front = (front + 1) % queue.length; // front 위치 갱신 (순환 큐)
    size--;

    // 크기가 너무 작아지면 배열을 절반으로 축소
    if (size > 0 && size == queue.length / 4) {
      resize(queue.length / 2);
    }
    return removedItem;
  }

  // 큐의 배열 크기 재조정
  private void resize(int newCapacity) {
    E[] newQueue = (E[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newQueue[i] = queue[(front + i) % queue.length]; // 순환 인덱스 활용
    }
    queue = newQueue;
    front = 0;
    rear = size;
  }
}
