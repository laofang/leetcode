/**
 * Leetcode1658题，将x减到0的最小操作数
 * 关键字：数组、哈希表、二分查找、前缀和、滑动窗口
 * 主要思路：
 * 1. 采用前缀和+二分法的思路
 * 2. 先求出前缀和，从后部分从0个元素开始尝试，在不同个元素数量下，二分法查找前部分前缀和，使之满足前后相加等于x
 * 3. 根据满足和是x，如果元素数量比记录更少，就更新记录
 */
public class LC1658 {
    public int minOperations(int[] nums, int x) {
        int ans = -1;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) left[i] = nums[i];
            else left[i] = left[i - 1] + nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) right[i] = nums[i];
            else right[i] = right[i + 1] + nums[i];
        }
        int i = n;
        while (i >= 0) {
            int target = x;
            if (i != n) {
                if (right[i] > x) break;
                if (right[i] == x) {
                    if (ans == -1 || n - i < ans) {
                        ans = n - i;
                        break;
                    }
                }
                target = x - right[i];
            }

            int l = 0;
            int r = i;
            while (l < r) {
                int half = (l + r) / 2;
                if (left[half] == target) {
                    if (ans == -1 || ans > (half + 1 + n - i)) {
                        ans = half + 1 + n - i;
                    }
                    break;
                } else if (left[half] > target) {
                    r = half;
                } else {
                    l = half + 1;
                }
            }
            i--;
        }
        return ans;
    }
}
