/**
 * Leetcode1295题，统计位数为偶数的数字
 * 关键字：数组
 * 主要思路：
 * 1. 简单题，直接暴力循环
 */
public class LC1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            int cnt = 0;
            while(num > 0) {
                cnt++;
                num /= 10;
            }
            if(cnt % 2 == 0) ans++;
        }
        return ans;
    }
}
