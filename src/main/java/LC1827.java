/**
 * Leetcode1827题，最少操作使数组递增
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 如果后一个不大于前一个，就增大到比前一个大1，累计这个增量
 */
public class LC1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                ans += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return ans;
    }
}
