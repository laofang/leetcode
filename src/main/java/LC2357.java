import java.util.Arrays;

/**
 * Leetcode2357题，使数组中所有元素等于零
 * 关键字：贪心、数组、哈希表、排序、模拟、堆
 * 主要思路：
 * 1. 去零去重，剩余的就是答案，除零外相同的数字，会被一次清掉
 */
public class LC2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(; i < nums.length;i++) {
            if(nums[i] != 0) break;
        }
        if(i == nums.length) return 0;
        int ans = 1;
        int cur = nums[i];
        for(i = i+1; i < nums.length; i++) {
            if(nums[i] == cur) continue;
            cur = nums[i];
            ans++;
        }
        return ans;
    }
}
