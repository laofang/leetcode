/**
 * Leetcode268题，丢失的数字
 * 关键字：数组、位运算、哈希
 * 主要思路：
 * 1. 求[0,n]的和与给定数组的和做差即可
 * 2. 解析里有个异或的方式，也可
 */
public class LC268 {
    public int missingNumber(int[] nums) {
        //求和相减，没什么说的
        int ans = (1 + nums.length ) * nums.length / 2;
        for(int i = 0; i < nums.length; i++) {
            ans -= nums[i];
        }
        return ans;
    }
}
