/**
 * Leetcode1752题，检查数组是否经排序和轮转得到
 * 关键字：数组
 * 主要思路：
 * 1. 如果可以轮转得到，nums中最多出现一次，nums[i] < nums[i-1]的情况
 * 2. 如果出现了nums[i] < nums[i-1]的情况，那一定有nums[nums.length - 1] <= nums[0]的情
 */
public class LC1752 {
    public boolean check(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                if(++cnt > 1) return false;
            }
        }
        if(cnt == 0) return true;
        return nums[nums.length - 1] <= nums[0];
    }
}
