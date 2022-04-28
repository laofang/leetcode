/**
 * Leetcode905题，按奇偶排序数组
 * 关键字：数组、双指针、排序
 * 主要思路：
 * 1. 前后指针，前面的指针位置如果是偶数向后移指针，如果是奇数和后面的数交换，后面的指针前移
 * 2. 重复上面步骤，直到左右指针相遇
 */
public class LC905 {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            if(nums[l] % 2 == 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                l++;
            }
        }
        return nums;
    }
}
