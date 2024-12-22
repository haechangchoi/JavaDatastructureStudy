package Tree.DisJointSet;

public class Node {

  int parent;
  int rank;

  public Node(int newParent, int newRank) {
    parent = newParent;
    rank = newRank;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
}
