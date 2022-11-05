import java.util.Arrays;

/**
 * Leetcode628题，三个数的最大乘积
 * 关键字：数组、数学
 * 主要思路：
 * 1. 可能是三个最大正数相乘，可能一个最大正数和两个最小负数
 */
public class LC628 {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mul1 = nums[0] * nums[1] * nums[n-1];
        int mul2 = nums[n-1] * nums[n-2] * nums[n-3];
        return Math.max(mul1,mul2);
    }
}
