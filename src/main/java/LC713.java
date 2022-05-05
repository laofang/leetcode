/**
 * Leetcode713题，乘积小于K的子数组
 * 关键字：数组、滑动窗口
 * 主要思路：
 * 1. 左右指针从0开始
 * 2. 连续乘积，如果大于k，左指针移动，此时要除以左指针前一个数字
 * 3. 每当小于的情况，ans += r - l + 1
 */
public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0,r = 0;
        int curTotal = 1;
        int ans = 0;
        if(k <= 1) return 0;
        while(r < nums.length) {
            curTotal *= nums[r];
            while(curTotal >= k) {
                curTotal /= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
