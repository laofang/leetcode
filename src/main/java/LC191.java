/**
 * Leetcode191题，位1的个数
 * 关键字：位运算
 * 主要思路：
 * 1. 通过给定数字每位 & 1运算统计
 */
public class LC191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0) {
            if (((n & 1) == 1)) ++ans;
            n = n >>> 1;
        }
        return ans;
    }
}
