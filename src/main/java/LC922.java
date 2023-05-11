/**
 * Leetcode922题，按奇偶排序数组
 * 关键字：数组、双指针、排序
 * 主要思路：
 * 1. 双指针，一个遍历奇数下标、一个遍历偶数下标，一旦一个位置不符合，一定会有一个对应的下标
 * 2. 找到每一对不符合的下标进行互换
 */
public class LC922 {
    public int[] sortArrayByParityII(int[] nums) {
        int l = 0,r = nums.length - 1;
        while(l < nums.length && r >= 1) {
            while(l < nums.length && nums[l] % 2 == 0) {
                l += 2;
            }
            while(r >= 1 && nums[r] % 2 == 1) {
                r -= 2;
            }
            if(l < nums.length && r >= 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }
}
