package tree;

class Lt110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode node) {
        // 예외 처리
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 왼쪽이나 오른쪽 노드가 -1이라면. 즉 루트노드라면, 동일하게 -1 리턴.
        // 각 노드의 높이 차이가 1 이상이면 -1 리턴.
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        // 위의 조건을 무사히 통과하면, 높은 노드의 높이에 +1한 값을 리턴. => 가장 하위 노드(null)의 0(-1 + 1)부터 하나씩 높이를 지정해 주는것.
        return Math.max(left, right) + 1;
    }
}
