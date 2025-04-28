package implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int bitmask = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("all")) {
                bitmask = (1 << 20) - 1;
                continue;
            }

            if (operation.equals("empty")) {
                bitmask = 0;
                continue;
            }

            int operator = Integer.parseInt(st.nextToken());

            if (operation.equals("add")) {
                bitmask |= (1 << (operator - 1));
            } else if (operation.equals("remove")) {
                bitmask &= ~(1 << (operator - 1));
            } else if (operation.equals("check")) {
                sb.append((bitmask & (1 << (operator - 1))) != 0 ? "1\n" : "0\n");
            } else if (operation.equals("toggle")) {
                bitmask ^= (1 << (operator - 1));
            }
        }

        System.out.println(sb);
    }
}
