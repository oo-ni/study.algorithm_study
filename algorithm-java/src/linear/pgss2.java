package linear;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Pgss2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = pre(input);
        System.out.println(result);
    }

    public static String pre(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            } else {
                if (count == 0) {
                    stack.addLast(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        return sb.toString();
    }
}