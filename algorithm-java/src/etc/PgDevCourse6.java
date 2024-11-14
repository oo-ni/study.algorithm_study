package etc;

import java.util.LinkedList;
import java.util.Queue;

class PgDevCourse6 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) {
            sum1 += num;
            q1.add(num);
        }

        for (int num : queue2) {
            sum2 += num;
            q2.add(num);
        }

        long want = (sum1 + sum2) / 2;
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int maxTry = queue1.length * 3;
        int answer = 0;

        while (sum1 != want && answer < maxTry) {
            if (sum1 > want) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            answer++;
        }

        return sum1 == want ? answer : -1;
    }
}
