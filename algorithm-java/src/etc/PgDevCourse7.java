package etc;

import java.util.Arrays;
import java.util.PriorityQueue;

class PgDevCourse7 {
    public int solution(int[][] jobs) {
        // 요청 시간 기준으로 작업 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 실행 시간 기준으로 처리할 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int currentTime = jobs[0][0];   // 첫 작업 시작 시간부터
        int totalTime = 0;              // 전체 대기 시간
        int jobNum = 0;                 // 현재 작업 번호
        int jobCount = jobs.length;     // 전체 작업 개수

        while (jobNum < jobCount || !pq.isEmpty()) {public int solution(int[][] jobs) {
            // 요청 시간 기준으로 작업 정렬
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            // 실행 시간 기준으로 처리할 우선순위 큐
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int currentTime = jobs[0][0];   // 첫 작업 시작 시간부터
            int totalTime = 0;              // 전체 대기 시간
            int jobNum = 0;                 // 현재 작업 번호
            int jobCount = jobs.length;     // 전체 작업 개수

            while (jobNum < jobCount || !pq.isEmpty()) {
                // 현재 시간보다 작거나 같은 도착 시간을 가진 작업 전부 큐에 추가
                while (jobNum < jobCount && jobs[jobNum][0] <= currentTime) {
                    pq.add(jobs[jobNum]);
                    jobNum++;
                }

                if (!pq.isEmpty()) {
                    int[] job = pq.poll();
                    currentTime += job[1];
                    totalTime += currentTime - job[0];
                } else {
                    currentTime = jobs[jobNum][0];
                }
            }

            return totalTime / jobCount;

        }
            while (jobNum < jobCount && jobs[jobNum][0] <= currentTime) {
                pq.add(jobs[jobNum]);
                jobNum++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[1];
                totalTime += currentTime - job[0];
            } else {
                // 작업 큐 비어있으면 다음 작업 시작시간으로 바로 이동
                if (jobNum < jobCount) {
                    currentTime = jobs[jobNum][0];
                }
            }
        }

        return totalTime / jobCount;

    }
}
