package sorting;

import java.util.Queue;

public class QuickSortExample {
    static int partition(int[] arr, int lo, int hi) {
        // 가장 마지막 인덱스를 피벗으로 설정
        int pivot = arr[hi];
        int left = lo;
        // 피벗 기준으로 작은 값 왼쪽, 큰 값 오른쪽으로 정렬 수행.
        for (int right = lo; right < hi; right++) {
            if (arr[right] < pivot) {

                // 현재 left 위치의 값과 right 위치의 값을 교환
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;     // left 포인터를 오른쪽으로 이동
            }
        }

        // 피벗 정렬
        int temp = arr[left];
        arr[left] = arr[hi];
        arr[hi] = temp;

        // 피벗의 위치 반환
        return left;
    }

    // 재귀 수행
    static int[] Quicksort(int[] arr, int lo, int hi) {
        // 배열의 범위 (lo ~ hi)가 유효한 경우에만 정렬 수행
        if (lo < hi) {
            // partition을 수행하고 피벗의 최종 위치 얻음
            int pivot = partition(arr, lo, hi);

            // 피벗 기준 왼쪽 부분 배열을 재귀적으로 정렬
            Quicksort(arr, lo, pivot - 1);
            // 피벗 기준 오른쪽 부분 배열을 재귀적으로 정렬
            Quicksort(arr,pivot + 1, hi);
        }

        return arr;
    }
}
