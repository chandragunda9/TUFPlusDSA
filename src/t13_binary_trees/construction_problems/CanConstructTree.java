package t13_binary_trees.construction_problems;

public class CanConstructTree {
    public boolean uniqueBinaryTree(int a, int b) {
        if (a == b)
            return false;
        return a == 2 || b == 2;
    }
}
