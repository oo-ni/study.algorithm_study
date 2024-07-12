package array;

import java.util.HashSet;
import java.util.Scanner;

public class bj5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> students = new HashSet<>();

        // 28명의 제출자 입력받기
        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            students.add(n);
        }
        sc.close();

        // 모든 출석번호 중 제출하지 않은 번호 찾기
        for (int i = 1; i <= 30; i++) {
            if (!students.contains(i)) {
                System.out.println(i);
            }
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[30];
//
//        for (int i = 0; i < 28; i++) {
//            int success = sc.nextInt();
//            arr[success - 1] = 1;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != 1) {
//                System.out.println(i + 1);
//            }
//        }
//    }
}
