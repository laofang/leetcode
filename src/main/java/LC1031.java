/**
 * Leetcode1031题，两个非重叠子数组的最大和
 * 关键字：数组、动态规划、滑动窗口
 * 主要思路：
 * 1. 先求出前缀和
 * 2. 先假设a在线，b在后，对b枚举，过程中会找到最大的A,在尝试最大的A和每个B的和找到和最大
 * 3. 同2，交换A,B位置
 */
public class LC1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + nums[i];
        return Math.max(f(s, firstLen, secondLen), f(s, secondLen, firstLen));
    }

    private int f(int[] s, int firstLen, int secondLen) {
        int maxSumA = 0, res = 0;
        for (int i = firstLen + secondLen; i < s.length; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            res = Math.max(res, maxSumA + s[i] - s[i - secondLen]);
        }
        return res;
    }
}
