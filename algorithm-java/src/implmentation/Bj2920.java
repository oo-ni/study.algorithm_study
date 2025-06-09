package implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scale = new int[8];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 7; i++) {
            if (scale[i] < scale[i + 1]) {
                descending = false;
            } else if (scale[i] > scale[i + 1]) {
                ascending = false;
            }
        }

        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
