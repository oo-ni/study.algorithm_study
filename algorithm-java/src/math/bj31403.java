package math;

import java.util.Scanner;

public class bj31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(A + B - C);

        String AB = String.valueOf(A) + B;

        System.out.println(Integer.valueOf(AB) - C);
    }
}
