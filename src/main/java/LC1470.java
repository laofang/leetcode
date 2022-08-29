/**
 * Leetcode1470题，重新排列数组
 * 关键字：数组
 * 主要思路：
 * 1. 将数组从n分成前后两个部分，来组装需要的数组
 */
public class LC1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int p = 0;
        int i = 0;
        while(i < nums.length) {
            ans[i++] = nums[p++];
            ans[i++] = nums[n++];
        }
        return ans;
    }
}
