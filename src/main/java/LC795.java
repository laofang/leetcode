/**
 * Leetcode795题，区间子数组个数
 * 关键字：数组、双指针
 * 主要思路：
 * 1. 以当前的nums[i]为末尾，可以贡献几个符合要求的子数组
 * 2. 有三种情况
 *      1. nums[i] > right，更新当前最近>right的数字坐标big
 *      2. nums[i] < left，此时需要找到前方最近的，在left和right之间的数字nums[mid]，
 *      如果mid > big，则(big,mid]的每个数到nums[i]所构成的数组都符合要求，数量是mid - big，对答案进行累加
 *      如果mid < big，表明big到i之间没有符合的要求的子数组
 *      3. nums[i] 在[left,right]中，则(big,i]与当前构成的子数组都符合要求，数量是i - big，对答案进行累加
 */
public class LC795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int bigger = -1;
        int mid = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > right) {
                bigger = i;
            } else if(nums[i] < left) {
                if(mid > bigger) {
                    ans += mid - bigger;
                }
            } else {
                mid = i;
                ans += i - bigger;
            }
        }
        return ans;
    }
}
