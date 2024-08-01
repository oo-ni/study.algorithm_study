package linear;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Bj2164 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.pollFirst());
    }
}
