import java.util.Comparator;

class BinTree<K, V> {
  static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;

    Node(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    K getKey() {
      return key;
    }

    V getValue() {
      return value;
    }

    void print() {
      System.out.println(value);
    }
  }

  private Node<K, V> root;
  private Comparator<? super K> comparator = null;

  public BinTree() {
    root = null;
  }

  public BinTree(Comparator<? super K> c) {
    this();
    comparator = c;
  }

  private int comp(K key1, K key2) {
    return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
  }

  private void addNode(Node<K, V> node, K key, V value) {
    int cond = comp(key, node.getKey());
    if (cond < 0) {
      if (node.left == null)
        node.left = new Node<K, V>(key, value, null, null);
      else
        addNode(node.left, key, value);
    } else if (cond > 0) {
      if (node.right == null)
        node.right = new Node<K, V>(key, value, null, null);
      else
        addNode(node.right, key, value);
    }
  }

  public void add(K key, V value) {
    if (root == null) {
      root = new Node<K, V>(key, value, null, null);
    } else {
      addNode(root, key, value);
    }
  }

  public V search(K key) {
    Node<K, V> p = root;

    while (true) {
      if (p == null)
        return null;
      int cond = comp(key, p.getKey());
      if (cond == 0) {
        return p.getValue();
      } else {
        p = cond > 0 ? p.right : p.left;
      }
    }
  }
}
