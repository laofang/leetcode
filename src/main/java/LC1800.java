/**
 * Leetcode1800题，最大升序子数组和
 * 关键字：数组
 * 主要思路：
 * 1. 求每一递增子数组的和，刷新最大的
 */
public class LC1800 {
    public int maxAscendingSum(int[] nums) {
        int i = 0;
        int max = 0;

        while(i < nums.length) {
            int sum = nums[i];
            ++i;
            while(i < nums.length && nums[i] > nums[i-1]) {
                sum += nums[i++];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
