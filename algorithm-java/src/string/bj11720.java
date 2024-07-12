package string;

import java.util.Scanner;

public class bj11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String nums = sc.next();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            // '0'을 빼서 char를 int로 변환
            sum += nums.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
