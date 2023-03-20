/**
 * Leetcode643题，子数组最大平均数I
 * 关键字：数组、滑动窗口
 * 主要思路：
 * 1. 滑动窗口，一个k大小的窗口进行移动，每次移动统计当前平均数，更新记录最大的值
 */
public class LC643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double ans = 0;
        int l = 0;
        int r = 0;
        while(r < k) {
            sum += nums[r];
            r++;
        }
        ans = (double) sum / k;
        while(r < nums.length) {
            sum -= nums[l];
            sum += nums[r];
            ans = Math.max((double) sum / k, ans);
            l++;
            r++;
        }
        return ans;
    }
}
