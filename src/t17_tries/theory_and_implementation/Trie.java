package t17_tries.theory_and_implementation;

class Node {
    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.containsKey(ch)) {
                //putting the reference node
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            //the letter is not found, there is no word that starts with the given prefix
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        //the prefix is found in the trie
        return true;
    }
}

