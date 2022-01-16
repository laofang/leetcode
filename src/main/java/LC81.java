/**
 * Leetcode81题，搜索旋转排序数组II
 * 关键字：数组
 * 主要思路：
 * 1. 二分查找
 */
public class LC81 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(nums.length == 1) {
            return nums[0] == target;
        }
        while(l <= r) {
            int mid = (l + r) >>>1;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if(nums[mid] <= nums[r]) {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
