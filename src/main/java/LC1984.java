import java.util.Arrays;

/**
 * Leetcode1984题，学生分数的最小差值
 * 关键字：数组、排序
 * 主要思路：
 * 1. 排序
 * 2. 相距k-1元素求差，得到最小的即可
 */
public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i + k - 1 < nums.length;i++) {
            ans = Math.min(ans,nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
