package t15_graphs.hard_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int k = 4;
        System.out.println(findOrder(dict, dict.length, k));
    }

    public static String findOrder(String[] dict, int N, int K) {
        int[] inDeg = new int[K];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String a = dict[i];
            String b = dict[i + 1];
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                int node1 = a.charAt(j) - 'a';
                int node2 = b.charAt(j) - 'a';
                if (node1 != node2) {
                    adj.get(node1).add(node2);
                    inDeg[node2]++;
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            char ch = (char) (rem + (int) 'a');
            sb.append(ch);
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        return sb.toString();
    }
}
