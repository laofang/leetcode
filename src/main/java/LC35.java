/**
 * Leetcode35题，搜索插入位置
 * 关键字：二分法，有序数组
 * 主要思路：
 * 1. 按34题的做法，只要求得第一个大于等于target位置即可
 * 2. 我的做法是求m的位置，如果不存在，r的位置来决定
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int m = (l + r) / 2;
            //如果存在返回
            if(nums[m] == target) {
                return m;
            }
            else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        //如果不存在，r的位置值小于target说明要插入的值为r+1
        if(nums[r] < target) {
            return r + 1;
            //r的位置大于target说明这就是最小大于的值，返回r即可
        } else {
            return r;
        }
    }
}
