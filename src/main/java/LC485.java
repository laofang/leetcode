/**
 * Leetcode485题，最大连续1的个数
 * 关键字：数组
 * 主要思路：
 * 1. 遍历统计，并更新最长长度
 */
public class LC485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = nums[0] == 1 ? 1 : 0;
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                ans = Math.max(ans,cnt);
                cnt = 0;
            } else if(nums[i] != nums[i-1]) {
                cnt = 1;
            } else {
                ++cnt;
            }
        }
        ans = Math.max(ans,cnt);
        return ans;
    }
}
