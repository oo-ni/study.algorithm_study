package math;

import java.util.HashMap;
import java.util.Map;

public class Pg120812 {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : array) {
            int count = map.getOrDefault(number, 0) + 1;
            if (count > maxCount) {
                maxCount = count;
                answer = number;
            } else if (count == maxCount) {
                answer = -1;
            }
            map.put(number, count);
        }

        return answer;
//        // K = 숫자, V = 빈도수
//        Map<Integer, Integer> map = new HashMap<>();
//
//        // getOrDefault로 기본값 0부터 1개씩 빈도 증가
//        for (int num : array) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int maxFreq = 0;
//        int maxFreqNum = -1;    // 제한사항에 원소가 0부터 시작할 수 있으므로 -1로 초기화.
//        int multiFreq = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > maxFreq) {
//                maxFreq = entry.getValue();
//                maxFreqNum = entry.getKey();
//                multiFreq = 0;
//            } else if (entry.getValue() == maxFreq) {
//                multiFreq++;
//            }
//        }
//
//        // 최빈값 여러개면 -1 리턴
//        if (multiFreq != 0) {
//            return -1;
//        }
//
//        return maxFreqNum;
    }
}
