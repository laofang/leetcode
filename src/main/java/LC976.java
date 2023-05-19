import java.util.Arrays;

/**
 * Leetcode976题，三角形的最大周长
 * 关键字：贪心、排序、数组、数学
 * 主要思路：
 * 1. 贪心，排序，遍历最长边，然后选择次小的两条边，如果能成就是最长的，不然就不满足三角形的规律
 */
public class LC976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--) {
            if(nums[i-1] + nums[i-2] > nums[i]) {
                return nums[i-2] + nums[i-1] + nums[i];
            }
        }
        return 0;
    }
}
