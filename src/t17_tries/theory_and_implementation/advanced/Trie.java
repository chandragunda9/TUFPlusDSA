package t17_tries.theory_and_implementation.advanced;

class Node {

    Node[] links;
    int cntPrefix;
    int cntEnd;

    public Node() {
        links = new Node[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void increaseEnd() {
        cntEnd++;
    }

    public void increasePrefix() {
        cntPrefix++;
    }

    public void reducePrefix() {
        cntPrefix--;
    }

    public void deleteEnd() {
        cntEnd--;
    }

    public int getCntEnd() {
        return cntEnd;
    }

    public int getCntPrefix() {
        return cntPrefix;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.containsKey(ch)) {
                curr.put(ch, new Node());
            }
            Node refTrie = curr.get(ch);
            refTrie.increasePrefix();

            curr = curr.get(ch);
        }
        curr.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else
                return 0;
        }
        return node.getCntEnd();
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else
                return 0;
        }
        return node.getCntPrefix();
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
                node.reducePrefix();
            }
            else
                return;
        }
        node.deleteEnd();
    }
}