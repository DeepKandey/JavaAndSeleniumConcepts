package dataStructuresAndAlgorithms.Trie;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumXOR {

    static class Node {
        Node[] link = new Node[2];

        boolean containsKey(int ind) {
            return link[ind] != null;
        }

        Node getNode(int ind) {
            return link[ind];
        }

        void put(int ind, Node node) {
            link[ind] = node;
        }
    }

    private static Node root;

    // Initialize your data structure here
    MaximumXOR() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.getNode(bit);
        }
    }

    int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                System.out.print(maxNum + " ");
                node = node.getNode(1 - bit);
            } else node = node.getNode(bit);
        }
        return maxNum;
    }

    static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        MaximumXOR maximumXOR = new MaximumXOR();
        for (int i = 0; i < n; i++) {
            maximumXOR.insert(arr1.get(i));
        }
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            maxi = Math.max(maxi, maximumXOR.getMax(arr2.get(i)));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int n = 2, m = 3;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(6, 8));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(7, 8, 2));
        System.out.println("\n" + maxXOR(n, m, arr1, arr2));
    }
}
