/**
 * Leetcode2016题，增量元素之间的最大差值
 * 关键字：数组
 * 主要思路：
 * 1. 记录前缀最小值
 * 2. 遍历与最小值做差，更新
 */
public class LC2016 {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for(int i = 1; i < nums.length; i++) {
            //根据要求，后大于前
            if(nums[i] > min) {
                //差更大的
                ans = Math.max(nums[i] - min,ans);
            } else {
                //更新前缀最小记录
                min = nums[i];
            }
        }
        return ans;
    }
}
