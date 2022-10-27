/**
 * Leetcode1822题，数组元素积的符号
 * 关键字： 数组、数学
 * 主要思路:
 * 1. 求出负数的数量即可
 */
public class LC1822 {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) return 0;
            else if(nums[i] < 0) ++cnt;
        }
        return cnt % 2 == 1 ? -1 : 1;
    }
}
