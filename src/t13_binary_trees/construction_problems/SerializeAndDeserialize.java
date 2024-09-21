package t13_binary_trees.construction_problems;

import t13_binary_trees.TreeNode;

import java.util.*;

public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder st = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (front == null) {
                st.append("n ");
            } else {
                st.append(front.data).append(" ");
                q.add(front.left);
                q.add(front.right);
            }
        }
        return st.toString();
    }

    public TreeNode deserialize1(String data) {
        if (data.isEmpty())
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int ind = 1;

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (ind < nodes.length) {
                String val1 = nodes[ind];
                if (!val1.equals("n")) {
                    front.left = new TreeNode(Integer.parseInt(val1));
                    q.add(front.left);
                } else {
                    front.left = null;
                }
                ++ind;
            }

            if (ind < nodes.length) {
                String val1 = nodes[ind];
                if (!val1.equals("n")) {
                    front.right = new TreeNode(Integer.parseInt(val1));
                    q.add(front.right);
                } else {
                    front.right = null;
                }
                ++ind;
            }
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode front = q.poll();
            if (!nodes[i].equals("n")) {
                front.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(front.left);
            }
            if (!nodes[++i].equals("n")) {
                front.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(front.right);
            }
        }
        return root;
    }

    public TreeNode createTree(int ind, List<Integer> nodes) {
        if (ind < nodes.size() && nodes.get(ind) != null) {
            TreeNode root = new TreeNode(nodes.get(ind));
            root.left = createTree(2 * ind + 1, nodes);
            root.right = createTree(2 * ind + 2, nodes);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        SerializeAndDeserialize obj = new SerializeAndDeserialize();
        Integer[] arr = {7, 3, 15, null, null, 9, 20};
        ArrayList<Integer> nodes = new ArrayList<>(Arrays.asList(arr));
        TreeNode root = obj.createTree(0, nodes);
        String data = obj.serialize(root);
        System.out.println(data);
        TreeNode res = obj.deserialize(data);
        System.out.println(res);
    }
}
