/**
 * Leetcode1413题，逐步求和得到正数的最小值
 * 关键字：数组、前缀和
 * 主要思路：
 * 1. 找到最小的前缀和
 * 2. startValue + 最小前缀和 >= 1
 * 3. startValue > 0
 */
public class LC1413 {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min,sum);
        }
        return 1 - min <= 0 ? 1 : 1 - min;
    }
}
