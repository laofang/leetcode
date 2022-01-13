/**
 * Leetcode747题，至少是其他数字两倍的最大数
 * 关键字：数组、排序
 * 主要思路：
 * 1. 就是看第一大的数，是不是第二大的数的两倍
 */
public class LC747 {
    public int dominantIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        int seMax = -1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                seMax = max;
                max = nums[i];
                index = i;
            } else if(nums[i] >= seMax) {
                seMax = nums[i];
            }
        }
        return (seMax == -1 || seMax == 0) || (max / seMax >= 2) ? index : -1;
    }
}
