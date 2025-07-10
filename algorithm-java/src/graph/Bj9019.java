package graph;

import java.io.*;
import java.util.*;

public class Bj9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            // 현재 숫자와 지금까지 명령어 큐에 저장
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(A, ""));
            visited[A] = true;

            // BFS
            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (now.num == B) {
                    System.out.println(now.commands);
                    break;
                }

                // D 연산
                int d = (now.num * 2) % 10000;
                if (!visited[d]) {
                    visited[d] = true;
                    queue.add(new Node(d, now.commands + "D"));
                }

                // S 연산
                int s = (now.num == 0) ? 9999 : now.num - 1;
                if (!visited[s]) {
                    visited[s] = true;
                    queue.add(new Node(s, now.commands + "S"));
                }

                // L 연산
                int l = (now.num % 1000) * 10 + (now.num / 1000);
                if (!visited[l]) {
                    visited[l] = true;
                    queue.add(new Node(l, now.commands + "L"));
                }

                // R 연산
                int r = (now.num % 10) * 1000 + (now.num / 10);
                if (!visited[r]) {
                    visited[r] = true;
                    queue.add(new Node(r, now.commands + "R"));
                }
            }
        }
    }

    // 숫자(num), 지금까지 명령어(commands) 저장하는 클래스
    static class Node {
        int num;           // 현재 숫자
        String commands;   // 지금까지 명령어 기록

        Node(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }
}