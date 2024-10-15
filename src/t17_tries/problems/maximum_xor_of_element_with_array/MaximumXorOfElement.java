package t17_tries.problems.maximum_xor_of_element_with_array;

import java.util.*;

class Node {
    Node[] links;

    Node() {
        links = new Node[2];
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public Node get(int bit) {
        return links[bit];
    }

    public void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMaxValWithGivenValue(int x) {
        Node node = root;
        int maxVal = 0;
        for (int i = 31; i >= 0; i--) {
            int bitAtIthInX = (x >> i) & 1;
            int revBit = 1 - bitAtIthInX;
            if (node.containsKey(revBit)) {
                maxVal = maxVal | (1 << i);
                node = node.get(revBit);
            } else {
                node = node.get(bitAtIthInX);
            }
        }
        return maxVal;
    }
}

public class MaximumXorOfElement {
    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        List<int[]> offlineQueries = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            offlineQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        Trie trie = new Trie();
        int i = 0;

        for (int[] q : offlineQueries) {
            while (i < nums.length && nums[i] <= q[0]) {
                trie.insert(nums[i]);
                i++;
            }

            if (i != 0) {
                ans.set(q[2], trie.getMaxValWithGivenValue(q[1]));
            } else {
                ans.set(q[2], -1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 0, 1};
        int[][] queries = {{3, 0}, {3, 10}, {7, 5}, {7, 9}};
        MaximumXorOfElement obj = new MaximumXorOfElement();
        System.out.println(obj.maximizeXor(nums, queries));
    }
}
