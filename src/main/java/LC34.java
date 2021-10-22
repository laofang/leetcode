/**
 * Leetcode34题，在排序数组中查找元素的第一个和最后一个位置
 * 关键字：有序数组，二分查找
 * 主要思路：
 * 1. 通过二分法，left<=right, nums[mid] >= target, right = mid-1 ,可以找到第一个不小于target的位置，即leftIndex
 * 2. 同样，left<=right, nums[mid] <= target, left = mid + 1,可以找到第一个不大于target的位置，即rightIndex
 * 3. 和其他二分法的问题一样，要格外注意分界问题，本题还要注意target不存在的情况
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearchLeftIndex(nums,target);
        res[1] = binarySearchRightIndex(nums,target);
        //其中有一个为-1，或者两个对应数字不相等，说明未找到
        if((res[0] == -1 || res[1] == -1) || nums[res[0]] != nums[res[1]]) {
            return new int[]{-1,-1};
        }
        return res;
    }
    /**
     * 查找第一个大于等于target的值的索引
     */
    public int binarySearchLeftIndex(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) {
                //右边界左移
                right = mid -1;
                //查找成功，记录一下
                res = mid;
            } else {
                //没找到，左边界右移
                left = mid + 1;
            }
        }
        return res;
    }

    /**
     * 查找第一个小于等于target的值的索引
     * 整体思路和上边的方法基本一致
     */
    public int binarySearchRightIndex(int[] nums,int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
