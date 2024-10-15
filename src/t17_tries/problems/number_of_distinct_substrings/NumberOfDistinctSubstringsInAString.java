package t17_tries.problems.number_of_distinct_substrings;

import java.util.HashSet;
import java.util.Set;

class Node {
    Node[] links;

    Node() {
        links = new Node[26];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
}

public class NumberOfDistinctSubstringsInAString {
    public int countDistinctSubstring(String s) {
        Node root = new Node();
        int n = s.length(), count = 0;

        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                    count++;
                }
                node = node.get(ch);
            }
        }
        //to count for the empty string as well
        return count + 1;
    }

    public int method1(String s) {
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));
                ans.add(str.toString());
            }
        }
        ans.add("");
        return ans.size();
    }

    public static void main(String[] args) {
        String st = "aba";
        NumberOfDistinctSubstringsInAString obj = new NumberOfDistinctSubstringsInAString();
        System.out.println(obj.method1(st));
        System.out.println(obj.countDistinctSubstring(st));
    }
}
