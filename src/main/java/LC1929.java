/**
 * Leetcode1929题，数组串联
 * 关键字：数组
 * 主要思路：
 * 1. 按顺序填充，填充两遍
 */
public class LC1929 {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int i = 0;
        for(; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        for(i = 0; i < nums.length; i++) {
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
