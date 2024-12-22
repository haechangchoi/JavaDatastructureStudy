package List.DoublyLinkedList;

public class Node <E>{

  private E item;
  private Node<E> next;
  private Node<E> prev;

  public Node(E item, Node<E> next, Node<E> prev){
    this.item = item;
    this.next = next;
    this.prev = prev;
  }

  public E getItem() {
    return item;
  }

  public void setItem(E item) {
    this.item = item;
  }

  public Node<E> getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }

  public Node<E> getPrev() {
    return prev;
  }

  public void setPrev(Node<E> prev) {
    this.prev = prev;
  }
}
