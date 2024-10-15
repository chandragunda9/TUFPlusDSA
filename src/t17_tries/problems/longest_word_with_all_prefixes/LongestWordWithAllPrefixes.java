package t17_tries.problems.longest_word_with_all_prefixes;

import java.util.Arrays;
import java.util.List;

class Node {
    Node[] links;
    boolean flag;

    public Node() {
        this.links = new Node[26];
        this.flag = false;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void setEnd() {
        this.flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean checkIfAllPrefixesExist(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (!node.isEnd())
                    //prefix is not present, so return false
                    return false;
            } else
                //if character itself missing, return false
                return false;
        }
        //all prefixes exist
        return true;
    }
}

public class LongestWordWithAllPrefixes {
    public String completeString(List<String> nums) {
        Trie trie = new Trie();
        //insert all the words
        for (int i = 0; i < nums.size(); i++) {
            String word = nums.get(i);
            trie.insert(word);
        }

        //check for each prefix in every word
        String ans = "";
        for (int i = 0; i < nums.size(); i++) {
            String word = nums.get(i);
            if (trie.checkIfAllPrefixesExist(word)) {
                if (word.length() > ans.length()) {
                    ans = word;
                } else if (word.length() == ans.length() && ans.compareTo(word) > 0) {
                    ans = word;
                }
            }
        }
        return ans.isEmpty() ? "None" : ans;
    }

    public static void main(String[] args) {
        String[] arr = {"n", "ni", "nin", "ninj", "ninja", "nil"};
//        String[] arr = {"ninja", "night", "nil"};
        List<String> li = Arrays.stream(arr).toList();
        LongestWordWithAllPrefixes obj = new LongestWordWithAllPrefixes();
        System.out.println(obj.completeString(li));
    }
}
