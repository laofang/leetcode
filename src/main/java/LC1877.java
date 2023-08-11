import java.util.Arrays;

/**
 * Leetcode1877题，数组中最大数对和的最小值
 * 关键字：贪心、数组、双指针、排序
 * 主要思路：
 * 1. 先排序，前后相加，选出最大的
 */
public class LC1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while(i < j) {
            ans = Math.max(ans,nums[i] + nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}
