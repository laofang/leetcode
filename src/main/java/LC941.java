/**
 * Leetcode941题，有效的山脉数组
 * 关键字：数组
 * 主要思路：
 * 1. 先递增，后递减
 */
public class LC941 {
    public boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i = 0;
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == N - 1) {
            return false;
        }
        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == N - 1;
    }
}
