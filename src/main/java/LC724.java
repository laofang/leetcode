/**
 * Leetcode724题，寻找数组中心下标
 * 关键字：数组、前缀和
 * 主要思路：
 * 1. 先求出前缀和，再从左向右遍历，找到位置i，使得i的左侧和等于i的右侧和
 */
public class LC724 {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            if(sum[i] == sum[nums.length] - sum[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
