  package Tree.DisJointSet;

  public class UnionFind {

    protected Node[] a;

    public UnionFind(Node[] iarray) {
      a = iarray;
    }

    protected int find(int i) {

      if(i != a[i].getParent()){
        // 루트 노드가 아니라면 재귀 호출해서 루트를 찾는다.
        a[i].setParent(find(a[i].getParent()));
      }

      return a[i].getParent();

      //i가 루트 노드라면 i == a[i].getParent
    }

    public void union(int i, int j) {

      int iroot = find(i);
      int jroot = find(j);

      if(iroot == jroot){
        return;
      }

      // rank가 더 높은 루트가 승자
      if(a[iroot].getRank() > a[jroot].getRank()){
        a[jroot].setParent(iroot); // iroot가 랭크다 더 높으므로 jroot의 부모로 설정
      } else if (a[iroot].getRank() < a[jroot].getRank()){
        a[iroot].setParent(jroot); // 반대
      } else { // 같다면 i를 승자로 처리하도록 임의로 설정
        a[jroot].setParent(iroot);
        int t = a[iroot].getRank()+1; // 랭크가 한 단계 높다
        a[iroot].setRank(t);
      }

      }
    }

