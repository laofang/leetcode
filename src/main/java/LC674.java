/**
 * Leetcode674题，最长连续递增序列
 * 关键字：数组
 * 主要思路：
 * 1. 双指针
 */
public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
        int l = 0;
        int r = 1;
        int ans = 0;
        while(r < nums.length && l < nums.length) {
            if(nums[r] > nums[r-1]) {
                r++;
            } else {
                ans = Math.max(ans,r-l);
                l = r;
                r = l+1;
            }
        }
        ans = Math.max(ans,r-l);
        return ans;
    }
}
