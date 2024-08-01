package tree;

class Lt938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 하위 노드 없으면 종료
        if (root == null) {
            return 0;
        }

        // 현재 노드의 값이 high보다 크다면, 오른쪽 서브트리를 탐색할 필요 없음
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // 현재 노드의 값이 low보다 작다면, 왼쪽 서브트리를 탐색할 필요 없음
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // 현재 노드의 값이 [low, high] 범위에 있는 경우:
        // 현재 노드의 값을 더하고, 왼쪽 및 오른쪽 서브트리 모두 탐색
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
