import java.util.Arrays;

/**
 * Leetcode891题，子序列宽度之和
 * 关键字：数组、数学、排序
 * 主要思路：
 * 1. 这是一道数学题，每个列宽和顺序没有关系，所以可以先排序
 * 2. 排序后，第i个元素，是前i个元素中最大的，又是后n - i个元素里最小的
 * 3. 所以可知，nums[i]作为子序列最大值，出现了2^i次方次；作为子序列最小值出现了2^(n-i-1)次
 * 4. 所以nums[i]对答案的贡献值为(2^i - 2^(n - 1 - i)) * nums[i]，累加这个结果
 */
public class LC891 {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        final int MOD = 1000000007;
        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pow2[i] = pow2[i-1] * 2 % MOD;
        }
        long ans = 0L;
        for(int i = 0; i < nums.length; i++) {
            ans += (long)(pow2[i] - pow2[nums.length - i - 1]) * nums[i];
        }
        return (int) ((ans % MOD + MOD) % MOD);
    }
}
