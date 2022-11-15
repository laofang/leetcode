/**
 * Leetcode775题，全局倒置与局部倒置
 * 关键字：数组、数学
 * 主要思路：
 * 1. 局部倒置属于全局倒置，如果局部倒置与全局倒置相等，那么只能存在局部倒置
 * 2. 如果存在非局部倒置的倒置存在，则返回false，所以需要一个数组，记录前缀最大值
 */
public class LC775 {
    public boolean isIdealPermutation(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i >= 2 && nums[i] < max[i-2]) return false;
            max[i] = nums[i] > max[i-1] ? nums[i] : max[i-1];
        }
        return true;
    }
}
