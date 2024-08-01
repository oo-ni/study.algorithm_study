package tree;

class Lt108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 예외 처리
        if (nums.length == 0) {
            return null;
        }

        // 배열 전체를 넘겨서 트리 생성 시작
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int lo, int hi) {
        // 예외 처리
        if (lo > hi) {
            return null;
        }

        // 중앙값 계산. 소수점은 내림으로
        int mid = lo + (hi - lo) / 2;
        // 배열의 중앙값으로 노드 생성
        TreeNode node = new TreeNode(nums[mid]);

        // 왼쪽 자식 노드는 배열 앞부분의 중앙값
        node.left = construct(nums, lo, mid - 1);
        // 오른쪽 자식 노드는 배열 뒷부분의 중앙값
        node.right = construct(nums, mid + 1, hi);

        return node;
    }
}
