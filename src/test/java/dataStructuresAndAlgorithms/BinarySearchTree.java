package dataStructuresAndAlgorithms;

public class BinarySearchTree {

	Node root;

	class Node {
		int key;
		String value;
		Node left, right;

		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public Node min() {
			if (left == null) {
				return this;
			} else {
				return left.min();
			}
		}
	}

	public BinarySearchTree() {
		root = null;
	}

	// Find
	public String find(int key) {

		// First find the node
		Node node = find(root, key);

		// Then return the value
		return node == null ? null : node.value;
	}

	private Node find(Node node, int key) {
		if (node == null || node.key == key) {
			return node;
		} else if (key < node.key) {
			return find(node.left, key);
		} else if (key > node.key) {
			return find(node.right, key);
		}
		return null;

		// Duplicates are not allowed( so we don't need too check for that)
	}

	// Insert
	public void insert(int key, String value) {
		root = insertItem(root, key, value);
	}

	public Node insertItem(Node node, int key, String value) {

		Node newNode = new Node(key, value);

		// if null
		// Set it here. We are done.
		if (node == null) {
			node = newNode;
			return node;
		}

		// Else
		// walk until we find a node that is null and set it there
		if (key < node.key) {
			node.left = insertItem(node.left, key, value);
		} else {
			node.right = insertItem(node.right, key, value);
		}

		// We have returned from the bottom
		// Return our fully constructed tree. We are done!
		return node;
	}

	// Delete: Three cases
	// 1. No child
	// 2. One child
	// 3. Two children

	// First 2 are simple. Third is more complex.

	// Case 1: No child- simply remove from tree by nullifying it.

	// Case 2: One children- copy the child to the node to be deleted and delete the
	// child

	// Case 3: Two children- re-gig the tree into a Case 1 or a Case 2

	// For third case we first need to
	// 1. Find the right side min
	// 2. copy it to the node we want to delete (creating the duplicate)
	// 3. Then delete the min value way down to the branch we just copied
	//
	// This works because you can represent a binary tree in more than one way
	// Here we are taking advantage of the fact to make our more complicated
	// 3rd case delete more simple by transforming it into case 1.

	// Step 1: Create a minvalue function
	public int findMinKey() {
		return findMin(root).key;
	}

	public Node findMin(Node node) {
		return node.min();
	}

	public void delete(int key) {
		root = delete(root, key);
	}

	public Node delete(Node node, int key) {
		if (node == null) {
			return null;
		} else if (key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else { // This is the node we want to delete

			// Case 1: No child
			if (node.left == null && node.right == null) {
				node = null;
			}

			// Case 2: One child
			else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			}

			// Case 3: Two children
			else {
				// Find the minimum node in the right (could also max on the left...)
				Node minRight = findMin((node.right));

				// Duplicate it by copying its values here
				node.key = minRight.key;
				node.value = minRight.value;

				// Now go ahead and delete the node we just duplicated(same key)
				node.right = delete(node.right, node.key);
			}
		}
		return node;
	}

	// Print
	public void printInOrderTraversal() {
		System.out.println("--InOrder traversal of the tree--");
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.key);
			inOrderTraversal(node.right);
		}
	}

	public void printPreOrderTraversal() {
		System.out.println("--PreOrder traversal of the tree--");
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.println(node.key); // root
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
		}
	}

	public void printPostOrderTraversal() {
		System.out.println("--PostOrder traversal of the tree--");
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
			System.out.println(node.key); // root
		}
	}

	public void prettyPrint() {
		// hard coded print out of binary tree depth=3

		int rootLeftkey = root.left == null ? 0 : root.left.key;
		int rootRightKey = root.right == null ? 0 : root.right.key;

		int rootLeftLeftKey = 0;
		int rootLeftRightKey = 0;

		if (root.left != null) {
			rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
			rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
		}

		int rootRightLeftKey = 0;
		int rootRightRightKey = 0;

		if (root.right != null) {
			rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
			rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
		}

		System.out.println("  " + root.key);
		System.out.println(" / \\");
		System.out.println(" " + rootLeftkey + "  " + rootRightKey);
		System.out.println("/ \\ / \\");
		System.out.println(rootLeftLeftKey + " " + rootLeftRightKey + " " + rootRightLeftKey + " " + rootRightRightKey);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree obj = new BinarySearchTree();
		obj.insert(6, "Family");
		obj.insert(2, "Deepak");
		obj.insert(8, "Akansha");
		obj.insert(3, "Patna");
		obj.insert(1, "Pune");
		obj.insert(7, "Tata");
		obj.insert(9, "Mumbai");

		obj.prettyPrint();
		obj.printInOrderTraversal();
		obj.printPreOrderTraversal();
		obj.printPostOrderTraversal();

		System.out.println(obj.find(6));
		System.out.println(obj.find(2));
		System.out.println(obj.find(8));
		System.out.println(obj.find(3));
		System.out.println(obj.find(1));
		System.out.println(obj.find(7));
		System.out.println(obj.find(9));

		System.out.println("Minimum Key in the tree:- " + obj.findMinKey());
		
		obj.delete(1);
		obj.prettyPrint();
		obj.delete(2);
		obj.prettyPrint();
		
		obj.insert(1, "Pune");
		obj.insert(4, "Deepak");
		obj.prettyPrint();
		
		obj.delete(3);
		obj.prettyPrint();
		
		obj.insert(5, "Patna");
		obj.prettyPrint();
		obj.printInOrderTraversal();
	}

}