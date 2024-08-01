package etc;

class PgDevCourse1 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[arr[0].length];          // 열 길이만큼
        int start = 0, next = 0, dist = 0;              // 시작점, 이동점, 거리

        for(int k = 0; k < answer.length; k++) {        // 숫자 순서대로 결과에 추가

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == k) {
                        next = start;                   // 시작점 변경
                        start = j;
                        if(i != 0) {                    // 행 인덱스가 0일 경우 제외
                            dist += Math.abs(next - start);
                        }
                        continue;
                    }
                }
            }

            answer[k] = dist;                           // 배열에 거리 값 추가
            dist = 0;                                   // 값 초기화
        }
        return answer;
    }
}