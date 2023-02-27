/**
 * Leetcode1144题，递减元素使数组呈锯齿状
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 分别尝试奇数索引位置的值小于两边和偶数索引位置的值小于两边，分别变化的总值
 * 2. 取两种情况较小的一个
 */
public class LC1144 {
    public int movesToMakeZigzag(int[] nums) {
        int oddCnt = 0;
        int evenCnt = 0;
        for(int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            if(i % 2 == 0) {
                if(i == 0 && i != nums.length - 1) {
                    min = nums[i+1];
                } else if(i != 0 && i == nums.length - 1) {
                    min = nums[i-1];
                } else if(i != 0 && i != nums.length - 1) {
                    min = Math.min(nums[i-1],nums[i+1]);
                }
                if(nums[i] >= min) evenCnt += (nums[i] - min + 1);
            } else {
                if(i == 0 && i != nums.length - 1) {
                    min = nums[i+1];
                } else if(i != 0 && i == nums.length - 1) {
                    min = nums[i-1];
                } else if(i != 0 && i != nums.length - 1) {
                    min = Math.min(nums[i-1],nums[i+1]);
                }
                if(nums[i] >= min) oddCnt += (nums[i] - min + 1);
            }
        }
        return Math.min(oddCnt,evenCnt);
    }
}
