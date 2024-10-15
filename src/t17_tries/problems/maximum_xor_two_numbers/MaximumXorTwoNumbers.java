package t17_tries.problems.maximum_xor_two_numbers;

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

    public int getMaxXorWithGivenValue(int x) {
        Node node = root;
        int maxNo = 0;
        for (int i = 31; i >= 0; i--) {
            int bitAtIthInX = (x >> i) & 1;
            int revBit = 1 - bitAtIthInX;
            if (node.containsKey(revBit)) {
                maxNo = maxNo | (1 << i);
                node = node.get(revBit);
            } else {
                node = node.get(bitAtIthInX);
            }
        }
        return maxNo;
    }
}

public class MaximumXorTwoNumbers {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            maxValue = Math.max(maxValue, trie.getMaxXorWithGivenValue(x));
        }
        return maxValue;
    }
}
