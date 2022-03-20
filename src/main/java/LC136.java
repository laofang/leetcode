/**
 * Leetcode136题，只出现一次的数字
 * 关键字：位运算、数组
 * 主要思路：
 * 1. 将数组中所有元素进行连续的异或运算（相同的两个异或等于0，0与任何元素异或等于元素本身）
 */
public class LC136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
