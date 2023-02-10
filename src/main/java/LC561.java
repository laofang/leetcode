import java.util.Arrays;

/**
 * Leetcode561题，数组拆分
 * 关键字：贪心、数组、排序、计数排序
 * 主要思路：
 * 1. 最大值不能得到，可以组成（次大值，最大值）的组合，可以获得次大值
 * 2. 以此类推，可以获得第一个，第三个，第五个……，计算总和即可
 */
public class LC561 {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int k = nums.length / 2;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i%2 == 0) ans += nums[i];
        }
        return ans;
    }
}
