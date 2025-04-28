package linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 스택에 push하는 순서는 반드시 오름차순
// 목표 수열을 스택으로 만들 수 있는가
class Bj1874 {
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 목표 수열 입력
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int idx = 0;

        while (idx < n) {
            int value = nums[idx];

            // start + 1부터 value까지 push
            if (start < value) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                // 오름차순 유지해야하니까 변수 초기화
                start = value;
            }

            // top 원소가 입력값과 다르면
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
            // 인덱스 증가시켜주기
            idx++;

        }


        System.out.println(sb);

    }
}
