/**
 * Leetcode44题，通配符匹配
 * 关键字；动态规划、模式匹配
 * 主要思路：
 * 1. 可以参考leetcode第10题，这道题相对简单一点
 * 2. 动态规划状态转移方程：
 *      1. 如果p[j-1]是字符或'?'，即s[i-1] = p[j-1]或p[j-1] = '?',dp[i][j] = dp[i-1][j-1]
 *      2. 如果p[j-1]是'*'，有两种情况：
 *          1. '*'匹配了0个字符，则dp[i][j] = dp[i][j-1]
 *          2. '*'匹配了>0个字符，则dp[i][j] = dp[i-1][j]
 */
public class LC44 {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length()+1];

        dp[0][0] = true;
        //例如s="",p="****"
        for(int i = 1; i <= p.length(); ++i) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                //s[i-1] == p[j-1] || p[j-1] == '?'
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                    //p[j-1] == '*'
                } else if(p.charAt(j-1) == '*') {
                    //如果*未使用,dp[i][j-1],如果*使用,dp[i-1][j];
                    if(dp[i-1][j] || dp[i][j-1]) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
