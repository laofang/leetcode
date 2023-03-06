/**
 * Leetcode1653题，使字符串平衡的最少删除次数
 * 关键字：栈、字符串、动态规划
 * 主要思路：
 * 1. 可以用前缀和的方式，也可以用动态规划
 * 2. 前缀和的方式，就是得到每个位置前面b的数量，和后面a的数量，找到两者和最少的数量
 * 3. 动态规划，就是当前字符的'a'是否保留，不保留dp+1；如果保留，则删除前面b的数量
 */
public class LC1653 {
    public int minimumDeletions(String s) {
        int dp = 0;
        int bCnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                dp = Math.min(dp + 1, bCnt);
            } else {
                bCnt++;
            }
        }
        return dp;
    }
}
