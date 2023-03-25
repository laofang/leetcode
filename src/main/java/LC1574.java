/**
 * Leetcode1574题，删除最短的子数组使剩余数组有序
 * 关键字：栈、数组、双指针、二分查找、单调栈
 * 主要思路：
 * 1. 采用双指针的方法，先记录非递减的前缀和非递减的后缀
 * 2. 遍历前缀的每个元素，找到后缀中对应的位置，然后更新中间待删掉子数组的最小长度
 */
public class LC1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }
        if (i >= j) {
            return 0;
        }
        int ans = Math.min(n - i - 1, j);
        for (int l = 0, r = j; l <= i; ++l) {
            while (r < n && arr[r] < arr[l]) {
                ++r;
            }
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }
}
