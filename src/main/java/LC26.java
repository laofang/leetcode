/**
 * Leetcode26题，删除有序数组中的重复项
 * 用时：3m9s
 * 主要思路：
 * 1. 记着当前下标，查找nums[n]!=nums[n-1]时，nums[n]就是一个新的数字，即nums[index + 1] = nums[i],index++;
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        //遍历
        for (int i = 0; i < nums.length; i++) {
            //向前看，若与前一个不同，说明是一个新元素
            if(i > 0 && nums[i] != nums[i-1]) {
                //将新元素添加到新位置
                nums[++index] = nums[i];
            }

        }
        return index + 1;
    }
}
