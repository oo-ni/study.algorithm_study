package implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()) ;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());  // 호텔 층 수
            int W = Integer.parseInt(st.nextToken());  // 각 층의 방 수
            int N = Integer.parseInt(st.nextToken());  // 몇 번째 손님

            int floor = (N % H == 0) ? H : (N % H);
            int room = (N % H == 0) ? (N / H) : (N / H + 1);

            sb.append(floor * 100 + room).append("\n");
        }
        System.out.print(sb.toString());
    }

}
