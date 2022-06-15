/**
 * Leetcode283题，移动零
 * 关键字：数组、双指针
 * 主要思路：
 * 1. 使用双指针，当前指针位置为0，则移动另一指针移动到不为0的位置，进行交换
 * 2. 重复1过程
 */
public class LC283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                i++;
                if(j < i) j = i;
                continue;
            }
            if(i >= nums.length) break;
            while(j < nums.length && nums[j] == 0) {
                j++;
                continue;
            }
            if(j >= nums.length) break;
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }
}
