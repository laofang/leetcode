/**
 * Leetcode2057题，值相等的最小索引
 * 关键字：数组
 * 主要思路：
 * 1. 没什么好说的，过于简单了
 */
public class LC2057 {
    public int smallestEqual(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
