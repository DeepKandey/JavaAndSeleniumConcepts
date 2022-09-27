package dataStructuresAndAlgorithms.BinaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfNodes = Integer.parseInt(br.readLine());

        Node node = null;

        for (int i = 0; i < noOfNodes; i++) {
            int key = Integer.parseInt(br.readLine());
            node = insertIntoBST(node, key);
        }

        System.out.println("Inorder traversal:--");
        printInorder(node);
        System.out.println("\nIs 50 present in BST: " + searchInBST(node, 50));
        System.out.println("Is 33 present in BST: " + searchInBST(node, 33));
    }

    private static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data) {
            // insert in right part
            root.right = insertIntoBST(root.right, data);
        } else
            root.left = insertIntoBST(root.left, data);

        return root;
    }

    private static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static boolean searchInBST(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (data > root.data) {
            searchInBST(root.right, data);
        } else
            searchInBST(root.left, data);

        return false;
    }

    private static Node deleteFromBST(Node root, int data) {
        // Base Case
        if (root == null) {
            return null;
        }

        // Recur down the tree
        if (root.data > data) {
            root.left = deleteFromBST(root.left, data);
        } else if (root.data < data) {
            root.right = deleteFromBST(root.right, data);
        }

        // if key is same as root's key, then this is the node
        else {
            // node with only 1 child
            if (root.left == null & root.right != null) return root.right;
            else if (root.right == null & root.left != null) return root.left;

            // node with 2 child
            root.data = minValue(root.right);

            // delete the inorder successor
            root.right = deleteFromBST(root.right, root.data);
        }
        return root;
    }

    private static int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}


/*
7
50
30
20
40
70
60
80
 */