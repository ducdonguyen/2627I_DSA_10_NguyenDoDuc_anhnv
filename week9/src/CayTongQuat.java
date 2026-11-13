import java.util.ArrayList;
import java.util.List;

public class CayTongQuat {

  // Đặt Node vào trong class CayTongQuat
  private static class Node {
    int FirstChild;
    int NextSibling;
    String data;

    public Node(String data) {
      this.data = data;
      this.FirstChild = -1;
      this.NextSibling = -1;
    }
  }

  private List<Node> nodes;
  private int rootIndex;

  public CayTongQuat() {
    nodes = new ArrayList<>();
    rootIndex = -1;
  }

  public void setRootIndex(String val) {
    Node root = new Node(val);
    rootIndex = 0;
    nodes.clear();
    nodes.add(root);
  }

  public void addChild(int parentIdx, String val) {
    if (parentIdx < 0 || parentIdx >= nodes.size()) return;

    Node newNode = new Node(val);
    int newNodeIdx = nodes.size();
    nodes.add(newNode);

    if (nodes.get(parentIdx).FirstChild == -1) {
      nodes.get(parentIdx).FirstChild = newNodeIdx;
    } else {
      int current = nodes.get(parentIdx).FirstChild;
      while (nodes.get(current).NextSibling != -1) {
        current = nodes.get(current).NextSibling;
      }
      nodes.get(current).NextSibling = newNodeIdx;
    }
  }

  public int findFirstChild(int nodeInx) {
    if (nodeInx < 0 || nodeInx >= nodes.size()) return -1;
    return nodes.get(nodeInx).FirstChild;
  }

  public int findNextSibling(int nodeInx) {
    if (nodeInx < 0 || nodeInx >= nodes.size()) return -1;
    return nodes.get(nodeInx).NextSibling;
  }

  public int findParent(int nodeIdx) {
    if (nodeIdx == rootIndex || nodeIdx < 0 || nodeIdx >= nodes.size()) return -1;
    return findParentRecursive(rootIndex, nodeIdx);
  }

  private int findParentRecursive(int curr, int targetIdx) {
    if (curr == -1) return -1;

    int child = nodes.get(curr).FirstChild;
    while (child != -1) {
      if (child == targetIdx) {
        return curr;
      }
      int p = findParentRecursive(child, targetIdx);
      if (p != -1) return p; // Lưu ý: Cần return p khi p != -1
      child = nodes.get(child).NextSibling;
    }
    return -1;
  }

  public void printInfo(int idx) {
    System.out.println(nodes.get(idx).data);
  }

  public static void main(String[] args) {
    CayTongQuat tree = new CayTongQuat();
    tree.setRootIndex("A");
    tree.printInfo(0);
  }
}