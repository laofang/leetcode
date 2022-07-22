/**
 * Leetcode91题，解码方法
 * 关键字：字符串、动态规划
 * 主要思路：
 * 1. 使用动态规划
 * 2. 这道题和上楼梯，每次一阶或两阶的题比较像
 * 3. 和上楼梯不同的时，不一定每次都可以上，要判断一个数字，或两个数字构成的数字是否合法
 * 4. dp[i] = dp[i-1] + dp[i-2]
 * 失误：
 * 1. 开始的时候没注意到问题规模，使用非记忆化递归，直接超时了
 */
public class LC91 {
    public int numDecodings(String s) {
        if(s.length() == 1 && s.charAt(0) != '0') return 1;
        char[] chs = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        if(chs[0] == '0') {
            return 0;
        } else {
            dp[1] = 1;
            if(chs[1] != '0') dp[2]++;
            if(chs[0] < '2' || chs[0] =='2' && chs[1] < '7') dp[2]++;
        }
        for(int i = 3; i < dp.length; i++) {
            if(chs[i-1] != '0') dp[i] = dp[i-1];
            if(chs[i-2] != '0' && (chs[i-2] < '2' || chs[i-2] =='2' && chs[i-1] <'7')) dp[i] += dp[i-2];
        }

        return dp[dp.length - 1];
    }
}
