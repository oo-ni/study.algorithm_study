package etc;

import java.util.*;

// k: 상담 유형의 수, n: 멘토의 수, reqs: 각 참가자의 상담요청
class PgDevCourse3 {
    public int solution(int k, int n, int[][] reqs) {
        int[] mentors = new int[k];
        Arrays.fill(mentors, 1);    // 첨엔 각 유형마다 1명씩 배정 (최소 한 명은 있어야하니까)

        // 남은 멘토 넣는 방법
        int remainMentors = n - k;
        while (remainMentors > 0) {
            int bestType = -1;
            int minWaitTime = Integer.MAX_VALUE;

            // 유형별 멘토 한 명씩 추가해보고 제일 대기 시간이 적은거 찾기
            for (int type = 0; type < k; type++) {
                mentors[type]++;
                int waitTime = calculateWaitTime(k, reqs, mentors);
                if (waitTime < minWaitTime) {
                    minWaitTime = waitTime;
                    bestType = type;
                }
                mentors[type]--;    // 처음부터
            }

            // 제일 대기 시간 적게 들어자는 유형에 멘토 하나 배정
            mentors[bestType]++;
            remainMentors--;
        }

        return calculateWaitTime(k, reqs, mentors);
    }

    // 총 대기 시간 계산
    private int calculateWaitTime(int k, int[][] reqs, int[] mentors) {
        int totalWaitTime = 0;
        List<Queue<Integer>> mentorAvailableTimes = new ArrayList<>();

        // 상담 유형 별 멘토의 상담 가능 시간 큐 초기화
        for (int i = 0; i < k; i++) {
            mentorAvailableTimes.add(new PriorityQueue<>());
            for (int j = 0; j < mentors[i]; j++) {
                mentorAvailableTimes.get(i).add(0);     // 일단 0분 부터
            }
        }

        // 각 상담 요청 별 멘토 대기시간 계산
        for (int[] req : reqs) {
            int type = req[2] - 1;      // 상담 유형은 1부터 시작하니까 -1 해서 0 맞춤
            int startTime = req[0];     // 시각
            int counselTime = req[1];   // 상담 시간

            int waitTime = checkMentors(type, startTime, counselTime, mentorAvailableTimes);
            totalWaitTime += waitTime;
        }

        return totalWaitTime;
    }

    private int checkMentors(int type, int startTime, int counselTime, List<Queue<Integer>> mentorAvailableTimes) {
        // 상담 유형별로 멘토 대기 시간 추적
        Queue<Integer> availableTimes = mentorAvailableTimes.get(type);

        // 멘토가 사용 가능한 가장 빠른 시간
        int mentorAvailableTime = availableTimes.poll();

        // 멘토가 상담 가능한지 확인
        int waitTime = Math.max(0, mentorAvailableTime - startTime);

        // 상담 종료 시간을 계산 (시작 시간 + 대기 시간 + 상담 시간)
        int finishTime = startTime + waitTime + counselTime;

        availableTimes.add(finishTime);

        return waitTime;
    }

}
