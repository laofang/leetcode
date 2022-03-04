/**
 * Leetcode2104题，子数组范围和
 * 关键字：栈、数组、单调栈
 * 主要思路：
 * 1. 枚举每个范围
 * 2. [l,r]范围的最大值和最小值 可以通过nums[r]和[l,r-1]的范围的最大值和最小值来得到
 */
public class LC2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for(int j = i + 1; j < n; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
    //TODO Leetcode2104题，子数组范围和，可以尝试用单调栈的方式来做
}
