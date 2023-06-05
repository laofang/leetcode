/**
 * Leetcode2460题，对数组执行操作
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 纯粹模拟，效率较低
 */
public class LC2460 {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }
        int cur = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                int j = i + 1;
                while(j <= cur) {
                    nums[j-1] = nums[j];
                    j++;
                }
                nums[cur] = 0;
                cur--;
            }
        }
        return nums;
    }
}
