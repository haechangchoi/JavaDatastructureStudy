package Stack.ArrayStack;

import java.util.EmptyStackException;

public class ArrayStack <E> {

  private static final int INITIAL_CAPACITY = 10; // 초기 스택 크기

  private E s[]; // 스택을 저장하는 배열
  private int top; // 스택의 최상단 인덱스

  @SuppressWarnings("unchecked")
  public ArrayStack() {
    s = (E[]) new Object[INITIAL_CAPACITY];
    top = -1;
  }

  /**
   * 현재 스택의 크기(요소 수)를 반환합니다.
   */
  public int size() {
    return top + 1; // top 기본값 -1, 스택이 비어있으면 0이 나와야 함.
  }

  /**
   * 스택이 비어있는지 확인합니다.
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * 스택의 가장 위에 있는 요소를 반환하지만 제거하지 않습니다.
   */
  public E peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return s[top];
  }

  /**
   * 스택의 가장 위에 있는 요소를 제거하고 반환합니다. 필요 시 스택 크기를 절반으로 줄입니다.
   */
  public E pop() {
    if (isEmpty())
      throw new EmptyStackException();
    E item = s[top]; // 반환할 요소 저장
    s[top--] = null; // 요소 제거 및 top 감소

    // 배열이 필요 이상으로 크다면 축소
    if (size() > 0 && size() == s.length / 4) {
      resize(s.length / 2);
    }

    return item;
  }

  /**
   * 스택에 새 요소를 추가합니다. 필요 시 스택 크기를 두 배로 확장합니다.
   */
  public void push(E newItem) {
    if (size() == s.length) { // 배열이 꽉 찼을 경우
      resize(2 * s.length);
    }
    s[++top] = newItem; // 요소 추가 및 top 갱신

  }

  /**
   * 스택 배열의 크기를 조정합니다.
   *
   * @param newCapacity 새로운 배열의 크기
   */
  @SuppressWarnings("unchecked")
  private void resize(int newCapacity) {
    E[] temp = (E[]) new Object[newCapacity]; // 새로운 배열 생성
    for (int i = 0; i <= top; i++) {
      temp[i] = s[i]; // 기존 요소 복사
    }
    s = temp; // 배열 교체
  }

  /*

  resize 메서드를 구현할 때, Arrays.copyOf를 사용하면 어떨까
  private void resize(int newCapacity) {
    s = Arrays.copyOf(s, newCapacity);
  }

  */


}
