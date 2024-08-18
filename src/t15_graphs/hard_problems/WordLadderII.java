package t15_graphs.hard_problems;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String startWord = "der", endWord = "dfs";
        List<String> wordList = new ArrayList<>(Arrays.asList("des", "der", "dfr", "dgt", "dfs"));
        System.out.println(findSequences(startWord, endWord, wordList));
    }

    public static List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> se = new HashSet<>(wordList);
        List<String> usedWordsOnPreLevels = new ArrayList<>();
        List<List<String>> seq = new ArrayList<>();

        q.add(new ArrayList<>(Collections.singletonList(beginWord)));
        usedWordsOnPreLevels.add(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            List<String> rem = q.poll();
            int n = rem.size();
            if (rem.get(n - 1).equals(endWord)) {
                seq.add(rem);
                continue;
            }
            if (n > level) {
                for (String word : usedWordsOnPreLevels) {
                    se.remove(word);
                }
                level++;
            }
            String lastWord = rem.get(rem.size() - 1);
            char[] wordArr = lastWord.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char origChar = wordArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (origChar != ch) {
                        wordArr[i] = ch;
                        String changedWord = new String(wordArr);
                        if (se.contains(changedWord)) {
                            List<String> temp = new ArrayList<>(rem);
                            temp.add(changedWord);
                            q.add(temp);
                            usedWordsOnPreLevels.add(changedWord);
                        }
                    }
                }
                wordArr[i] = origChar;
            }
        }
        return seq;
    }
}
