package q4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TopDown {
    public static void main(String[] args) {
        SplayTree<Integer> t = SplayTree.create(1, 0, 2, 4, 3);

        assert t.findMin() == 0;
        assert t.findMax() == 4;
        assert t.contains(2) == true;

        t.insert(5);
        t.remove(1);
        t.print(t);
    }
}

class SplayTree<T extends Comparable<T>> implements Iterable<T> {

    private BinaryNode root;
    private final BinaryNode aux;

    public SplayTree() {
        root = null;
        aux = new BinaryNode(null);
    }

    /**
     * Build an empty Splay Tree
     * 
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> SplayTree<T> create() {
        return new SplayTree<T>();
    }

    /**
     * Build a Splay Tree with the given elements
     * 
     * @param <T>
     * @param elements
     * @return
     */
    public static <T extends Comparable<T>> SplayTree<T> create(T... elements) {
        SplayTree<T> tree = new SplayTree<T>();
        for (T element : elements) {
            tree.insert(element);
        }
        return tree;
    }

    /**
     * Insert the given element into the tree.
     * 
     * @param element The element to insert
     * @return False if element already present, true otherwise
     */
    public boolean insert(T element) {
        if (root == null) {
            root = new BinaryNode(element);
            return true;
        }
        splay(element);

        final int c = element.compareTo(root.key);
        if (c == 0) {
            return false;
        }

        BinaryNode n = new BinaryNode(element);
        if (c < 0) {
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
            n.right = root.right;
            n.left = root;
            root.right = null;
        }
        root = n;
        return true;
    }

    /**
     * Remove the given element from the tree.
     * 
     * @param element The element to remove.
     * @return False if element not present, true otherwise
     */
    public boolean remove(T element) {
        splay(element);

        if (element.compareTo(root.key) != 0) {
            return false;
        }

        // Now delete the root
        if (root.left == null) {
            root = root.right;
        } else {
            BinaryNode x = root.right;
            root = root.left;
            splay(element);
            root.right = x;
        }
        return true;
    }

    /**
     * Find the smallest element in the tree.
     * 
     * @return
     */
    public T findMin() {
        BinaryNode x = root;
        if (root == null)
            return null;
        while (x.left != null)
            x = x.left;
        splay(x.key);
        return x.key;
    }

    /**
     * Find the largest element in the tree.
     * 
     * @return
     */
    public T findMax() {
        BinaryNode x = root;
        if (root == null)
            return null;
        while (x.right != null)
            x = x.right;
        splay(x.key);
        return x.key;
    }

    /**
     * Find an item in the tree.
     * 
     * @param element The element to find
     * @return
     */
    public T find(T element) {
        if (root == null)
            return null;
        splay(element);
        if (root.key.compareTo(element) != 0)
            return null;
        return root.key;
    }

    /**
     * Check if the tree contains the given element.
     * 
     * @param element
     * @return True if present, false otherwise
     */
    public boolean contains(T element) {
        return find(element) != null;
    }

    /**
     * Test if the tree is logically empty.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * print tree
     */
    public void print(SplayTree<Integer> t) {
        for (int i : t) {
            System.out.print(i+" ");
        }
    }

    public Iterator<T> iterator() {
        return new SplayTreeIterator();
    }

    /**
     * Internal method to perform a top-down splay.
     * If the element is in the tree, then the {@link BinaryNode} containing that
     * element becomes the root.
     * Otherwise, the root will be the ceiling or floor {@link BinaryNode} of the
     * given element.
     * 
     * @param element
     */
    private void splay(T element) {
        BinaryNode l, r, t, y;
        l = r = aux;
        t = root;
        aux.left = aux.right = null;
        while (true) {
            final int comp = element.compareTo(t.key);
            if (comp < 0) {
                if (t.left == null)
                    break;
                if (element.compareTo(t.left.key) < 0) {
                    y = t.left; /* rotate right */
                    t.left = y.right;
                    y.right = t;
                    t = y;
                    if (t.left == null)
                        break;
                }
                r.left = t; /* link right */
                r = t;
                t = t.left;
            } else if (comp > 0) {
                if (t.right == null)
                    break;
                if (element.compareTo(t.right.key) > 0) {
                    y = t.right; /* rotate left */
                    t.right = y.left;
                    y.left = t;
                    t = y;
                    if (t.right == null)
                        break;
                }
                l.right = t; /* link left */
                l = t;
                t = t.right;
            } else {
                break;
            }
        }
        l.right = t.left; /* assemble */
        r.left = t.right;
        t.left = aux.right;
        t.right = aux.left;
        root = t;
    }

    private class BinaryNode {

        public final T key; // The data in the node
        public BinaryNode left; // Left child
        public BinaryNode right; // Right child

        public BinaryNode(T theKey) {
            key = theKey;
            left = right = null;
        }
    }

    private class SplayTreeIterator implements Iterator<T> {

        private final Stack<BinaryNode> nodes;

        public SplayTreeIterator() {
            nodes = new Stack<BinaryNode>();
            pushLeft(root);
        }

        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        public T next() {
            BinaryNode node = nodes.pop();
            if (node != null) {
                pushLeft(node.right);
                return node.key;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void pushLeft(BinaryNode node) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
        }

    }

}