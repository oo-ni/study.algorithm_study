package array;

import java.util.ArrayList;
import java.util.Scanner;

public class bj10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i])
                count += 1;
        }
        System.out.println(count);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//
//        for (int i = 0; i < N; i++) {
//            int arrNum = sc.nextInt();
//            arr.add(arrNum);
//        }
//
//        int v = sc.nextInt();
//        int count = 0;
//
//        for (int i = 0; i < arr.toArray().length; i++) {
//            if (arr.get(i) == v) {
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
}
