package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <E extends Comparable<E>> {

  Node<E> root;

  public BinaryTree() {
    this.root = null;
  }

  public Node<E> getRoot() {
    return root;
  }

  public void setRoot(Node<E> root) {
    this.root = root;
  }

  public boolean isEmpty() {
    return root == null;
  }

  // 전위 순회
  public void preOrder(Node<E> node) {
    if (node != null) {
      System.out.print(node.getData() + " ");
      preOrder(node.getLeft());
      preOrder(node.getRight());
    }
  }

  // 중위 순회
  public void inOrder(Node<E> node) {
    if (node != null) {
      inOrder(node.getLeft());
      System.out.print(node.getData() + " ");
      inOrder(node.getRight());
    }
  }

  // 후위 순회
  public void postOrder(Node<E> node) {
    if (node != null) {
      postOrder(node.getLeft());
      postOrder(node.getRight());
      System.out.print(node.getData() + " ");
    }
  }

  // 레벨 순회
  public void levelOrder(Node<E> root) {
    Queue<Node<E>> q = new LinkedList<Node<E>>();
    Node<E> t;

    q.add(root);
    while(!q.isEmpty()) {

      t = q.remove();

      System.out.print(t.getData() + " ");

      if(t.getLeft() != null) {
        q.add(t.getLeft());
      }

      if(t.getRight() != null) {
        q.add(t.getRight());
      }
    }
  }


  // size와 height 후위 순회 기반


  // node를 루트로 하는 트리에 있는 노드 수
  public int size(Node<E> node){
    if(node == null) {
      return 0;
    } else {
      return 1 + size(node.getLeft()) + size(node.getRight());
    }
  }

  // node를 루트로 하는 트리의 높이
  public int height(Node<E> node){
    if(node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
  }
}
