package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 유클리드 호제법으로 최대 공약수(GCD)를 계산
2. 최소 공배수(LCM)는 두 수의 곱을 그들의 최소 공약수로 나누면 됨
 */

class Bj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = GCD(a, b);
        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
