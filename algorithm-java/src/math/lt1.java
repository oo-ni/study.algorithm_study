package math;

//class lt1 {
//    // 브루트포스
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
//}

import java.util.HashMap;
import java.util.Map;

class lt1 {
    public int[] twoSum(int[] nums, int target) {
        // 해쉬맵 활용
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // target에서 nums 값을 뺀 결과가 맵에 있으면 이를 반환.
            if (numsMap.containsKey(target - nums[i])) {
                return new int[] {numsMap.get(target - nums[i]), i};
            }
            // 없으면 추가
            numsMap.put(nums[i], i);
        }

        return null;
    }
}