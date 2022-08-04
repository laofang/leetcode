import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode1403题，非递增顺序的最小子序列
 * 关键字：贪心、数组、排序
 * 主要思路：
 * 1. 先进行排序，并求出数组的和；
 * 2. 将数组分为前后两个部分；
 * 3. 从后向前，逐一增大后一部分的和，当后一部分的和大于前部分的和，后部分就是答案；
 */
public class LC1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int rSum = 0;
        List<Integer> ans = new ArrayList<>();
        for(int j = nums.length - 1; j >= 0; j--) {
            rSum += nums[j];
            sum -= nums[j];
            ans.add(nums[j]);
            if(sum < rSum) break;
        }
        return ans;
    }
}
