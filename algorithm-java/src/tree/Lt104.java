package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Lt104 {
    // BFS
    public int maxDepthBFS(TreeNode root) {
        // 예외 처리
        if (root == null) {
            return 0;
        }

        // BFS 진행을 위한 queue 선언 LinkedList 자료형 활용.
        Queue<TreeNode> queue = new LinkedList<>();
        // root부터 queue에 삽입.
        queue.add(root);
        // 트리의 깊이
        int depth = 0;

        // 깊이별로 노드가 추가되는 BFS 구조
        while (!queue.isEmpty()) {
            // 반복처리할때마다 깊이 증가
            depth += 1;
            // queue.size() == 해당 깊이의 모든 노드 수
            int q_size = queue.size();
            // 모든 노드 수만큼 반복
            for (int i = 0; i < q_size; i++) {
                // 가장 먼저 삽입된 노드부터 추출. FIFO
                TreeNode cur = queue.poll();
                // 왼쪽 자식 노드가 있다면 큐에 삽입.
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                // 오른쪽 자식 노드가 있다면 큐에 삽입.
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        // BFS 반복 횟수 == 깊이
        return depth;
    }

    // DFS
    public int maxDepthDFS(TreeNode root) {
        // 더 이상 노드가 존재하지 않으면 0 리턴.
        if (root == null) {
            return 0;
        }

        // 왼쪽 노드에 깊이만큼 +1 처리된 값이 리턴된다.
        int left = maxDepthDFS(root.left);
        // 오른쪽 노드에 깊이만큼 +1 처리된 값이 리턴된다.
        int right = maxDepthDFS(root.right);

        // 왼쪽, 오른쪽 노드 중 큰 값에 +1 하여 리턴.
        return Math.max(left, right) + 1;
    }
}
