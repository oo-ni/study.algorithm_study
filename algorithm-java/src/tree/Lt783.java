package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lt783 {
    public int minDiffInBST(TreeNode root) {
        int prev = Integer.MIN_VALUE + 100000;
        int minDiff = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
