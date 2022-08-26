/**
 * Leetcode1464题，数组中两元素的最大乘积
 * 关键字：数组、排序、优先队列（堆）
 * 主要思路：
 * 1. 找到数组中最大和第二大两个值，分别减一，再卡卡一乘，就完活了
 */
public class LC1464 {
    public int maxProduct(int[] nums) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= a) {
                b = a;
                a = nums[i];
            } else if(nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
