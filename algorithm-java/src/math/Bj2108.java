package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 1. 산술평균
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        int avg = Math.round((float) sum / N);
        System.out.println(avg);

        // 2. 중앙값
        Arrays.sort(nums);
        int med = nums[N / 2];
        System.out.println(med);

        // 3. 최빈값
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(num));
        }

        List<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modeList.add(entry.getKey());
            }
        }

        Collections.sort(modeList);
        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);

        System.out.println(mode);
        
        // 4. 범위
        int rng = nums[N - 1] - nums[0];
        System.out.println(rng);

    }
}
