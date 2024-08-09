package graph;

import java.util.Scanner;

public class Bj4963 {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (W == 0 && H == 0) {
            W = sc.nextInt();
            H = sc.nextInt();


        }
    }
}
