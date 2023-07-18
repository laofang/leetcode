/**
 * Leetcode1480题，一维数组的动态和
 * 关键字：数组、前缀和
 * 主要思路：
 * 1. 不断累加，并且记录当前累加和
 */
public class LC1480 {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int cur = 0;
        for(int i = 0; i < nums.length; i++) {
            cur += nums[i];
            ans[i] = cur;
        }
        return ans;
    }
}
