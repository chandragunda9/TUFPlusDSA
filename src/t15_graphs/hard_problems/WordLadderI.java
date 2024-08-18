package t15_graphs.hard_problems;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("des", "der", "dfr", "dgt", "dfs"));
        String startWord = "der", targetWord = "dfs";
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }

    static class Node {
        String word;
        int length;

        public Node(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> se = new HashSet<>(wordList);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startWord, 1));
        se.remove(startWord);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            String word = rem.word;
            int len = rem.length;
            if (word.equals(targetWord)) {
                return len;
            }
            char[] wordArr = word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char origCh = wordArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (origCh != ch) {
                        wordArr[i] = ch;
                        String changedWord = new String(wordArr);
                        if (se.contains(changedWord)) {
                            q.add(new Node(changedWord, len + 1));
                            se.remove(changedWord);
                        }
                    }
                }
                wordArr[i]=origCh;
            }
        }
        return 0;
    }
}
