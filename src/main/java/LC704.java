/**
 * Leetcode704题，二分查找
 * 关键字：数组、二分查找
 * 主要思路：
 * 1. 基础的二分查找
 * 2. 初始的r是访问不到的，因为l与r相邻时(l+r) / 2 == l，所以r从nums.length开始
 * 3. 所以最终l+1 == r，才能到达循环的终止条件
 */
public class LC704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int half = (l + r) >> 1;
            if(nums[half] == target) {
                return half;
            } else if(nums[half] > target) {
                r = half;
            } else {
                l = half + 1;
            }
        }
        return -1;
    }
}
