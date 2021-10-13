/**
 * Leetcode27题，移除元素
 * 关键词：双指针，数组
 * 主要思路：
 * 1. 双指针，left指向需要放入的位置
 */
public class LC27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            //不同说明要将当前位置的值赋给left位置
            if(nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
