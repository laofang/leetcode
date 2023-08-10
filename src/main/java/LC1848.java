/**
 * Leetcode1848题，到目标元素的最小距离
 * 关键字：数组
 * 主要思路：
 * 1. 遍历每个数字，如果是target，记录abs(i-start)最小的那个
 */
public class LC1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }
}
