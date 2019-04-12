package binary_Serach_tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* Create A class BSTree and extend Comparable to use comparableTo method. */

public class BSTree<T extends Comparable<? super T>> {

	/* Tree Class define the structure of BST */
	private static class Tree<T> {
		T data; // data is T type variable
		Tree<T> right, left; // pointer or reference variable for BST

		public Tree(T data) { // constructor to access the data members of this class
			this.data = data;
			left = right = null;
		}
	}

	private Tree<T> root; // global variable root, which is a Root of BST

	public void successor(T key) { // successor is next node of any node in inorder traversal
		try {
			Tree<T> scsr = successor(root, key);
			if (scsr != null)
				System.out.println("Successor of " + key + " is " + scsr.data);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public void add(T newData) { // public add method to add new data into the Tree
		root = add(root, newData);
	}

	public void inorder() {
		inorder_traversal(root);
	}

	public void preorder() {
		preorder_traversal(root);
	}

	public void postorder() {
		postorder_traversal(root);
	}

	public void levelorder() {
		levelorder_traversal(root);
	}

	public int height() {
		return height(root);
	}

	public Tree<T> maximum() {
		return maximum(root);
	}

	public Tree<T> minimum() {
		return minimum(root);
	}

	public void deletenode(T key) {
		root = deletenode(root, key);
	}

	public boolean search(T key) {
		Tree<T> fact = Tree_Search(root, key);
		if (fact == null) {
			return false;
		}
		return true;
	}

	public boolean isBST() {
		prev = null;
		return isBST(root);
	}

	private Tree<T> add(Tree<T> root, T newdata) {
		if (root == null) {
			root = new Tree<T>(newdata);
			return root;
		}
		int compare = newdata.compareTo(root.data);
		if (compare < 0)
			root.left = add(root.left, newdata);
		else
			root.right = add(root.right, newdata);

		return root;
	}

	private T minValue(Tree<T> root) {
		if (root.left == null)
			return root.data;
		return minValue(root.left);
	}

	private Tree<T> deletenode(Tree<T> root, T key) {

		if (root == null)
			return root;

		int cmp = root.data.compareTo(key);

		if (cmp > 0) {
			root.left = deletenode(root.left, key);
		} else if (cmp < 0) {
			root.right = deletenode(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.data = minValue(root.right);
			root.right = deletenode(root.right, key);
		}
		return root;
	}

	private void inorder_traversal(Tree<T> root) {
		if (root == null)
			return;
		inorder_traversal(root.left);
		System.out.println(root.data);
		inorder_traversal(root.right);
	}

	private void preorder_traversal(Tree<T> root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preorder_traversal(root.left);
		preorder_traversal(root.right);
	}

	private void postorder_traversal(Tree<T> root) {
		if (root == null)
			return;
		postorder_traversal(root.left);
		postorder_traversal(root.right);
		System.out.println(root.data);
	}

	private int height(Tree<T> root) {
		if (root == null) {
			return 0;
		} else {
			int left = height(root.left);
			int right = height(root.right);
			if (left > right)
				return left + 1;
			else
				return right + 1;
		}
	}

	private void levelorder_traversal(Tree<T> root) {

		if (root == null) {
			return;
		}

		// Level order traversal can be done by sample BFS

		Queue<Tree<T>> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {

			while (q.size() > 0) {
				Tree<T> u = q.peek();
				System.out.println(u.data + " ");
				q.remove();
				if (u.left != null) {
					q.add(u.left);
				}
				if (u.right != null) {
					q.add(u.right);
				}
			}
			System.out.println();
		}
	}

	private Tree<T> Tree_Search(Tree<T> root, T key) {
		if (root == null || root.data == key) {
			return root;
		}
		int cmp = key.compareTo(root.data);
		if (cmp < 0)
			return Tree_Search(root.left, key);

		else
			return Tree_Search(root.right, key);
	}

	private Tree<T> minimum(Tree<T> root) {
		if (root.left == null) {
			System.out.println("Minimum Data: " + root.data);
			return root;
		}
		return minimum(root.left);
	}

	private Tree<T> maximum(Tree<T> root) {
		if (root.right == null) {
			System.out.println("Maximum Data: " + root.data);
			return root;
		}
		return maximum(root.right);
	}

	private List<T> myList = new LinkedList<T>();

	public boolean isBST_2() {
		isBST_2(root);
		T temp = myList.get(0);

		for (T i : myList) {
			if (temp.compareTo(i) > 0)
				return false;
			temp = i;
		}
		return true;
	}

	private void isBST_2(Tree<T> root) {
		if (root == null)
			return;
		isBST(root.left);
		myList.add(root.data);
		isBST(root.right);
	}

	private Tree<T> successor(Tree<T> root, T key) {
		Tree<T> newroot = Tree_Search(root, key);
		if (newroot == null) {
			return null;
		}
		if (newroot.right != null) {
			return minimum(newroot.right);
		} else {
			Tree<T> scsr = null;
			Tree<T> anstr = root;
			while (anstr != newroot) {
				int cmp = newroot.data.compareTo(anstr.data);
				if (cmp < 0) {
					scsr = anstr;
					anstr = anstr.left;
				} else
					anstr = anstr.right;
			}
			return scsr;
		}
	}

	public boolean isDuplicates() {
		if (isDuplicates(root))
			return true;

		return false;
	}

	private Set<T> mySet = new HashSet<>();

	private boolean isDuplicates(Tree<T> root) {
		if (root == null)
			return true;
		if (!isDuplicates(root.left))
			return false;
		if (!mySet.add(root.data))
			return false;
		return isDuplicates(root.right);
	}

	private Tree<T> prev;

	private boolean isBST(Tree<T> root) {
		if (root != null) {
			if (!isBST(root.left))
				return false;
			if (prev != null && root.data.compareTo(prev.data) < 0)
				return false;
			prev = root;
			return isBST(root.right);
		}
		return true;
	}
}
