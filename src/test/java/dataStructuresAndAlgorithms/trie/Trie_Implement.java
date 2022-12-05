package dataStructuresAndAlgorithms.trie;


class Node {
    Node[] links = new Node[26];
    boolean isTerminal = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node getKey(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    boolean isEnd() {
        return isTerminal;
    }

    void setEnd() {
        isTerminal = true;
    }
}

public class Trie_Implement {
    static Node root;

    public Trie_Implement() {
        root = new Node();
    }

    private static void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.getKey(word.charAt(i));
        }

        node.setEnd();
    }

    private static boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getKey(word.charAt(i));
        }
        return node.isEnd();
    }

    private static boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getKey(word.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie_Implement trie = new Trie_Implement();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
