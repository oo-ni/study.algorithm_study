package linear;

import java.util.*;

public class Pg12906 {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.addLast(num);
            }
        }

        int[] answer = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            answer[index++] = deque.pollFirst();
        }

        return answer;
    }
}