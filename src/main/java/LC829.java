/**
 * Leetcode829题，连续正数求和
 * 关键字：数学枚举
 * 主要思路：
 * 1.
 */
public class LC829 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0; n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;
    }
}
