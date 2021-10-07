/**
 * 这道题对我来说还是很难的，看了好久的解析才能基本理解
 * 以现在的水平，我不能独立用动态规划解决这道题
 * 主要思路：
 * 1. 确定dp的作用，dp[i][j]意味着s(0...i-1)和p(0...j-1)是匹配的
 * 2. 正常情况的状态转移，当s[i-1]和p[j-1]匹配，则dp[i][j] == dp[i-1][j-1],这是比较容易理解的
 * 3. 当p[j-1] == '*'时，如果s[i-1]和p[j-2]不匹配，我们可以当作p[j-2]和[j-1]这里0匹配，dp[i][j] == dp[i][j-2],也就是说干掉最后两个x*如果前面能匹配，则当前匹配，反之亦然
 *     1. 如果s[i - 1]和p[j-2]匹配，分为三种情况
 *          1. 0次匹配，例如s="ab',p="abb*",同样干掉b*，dp[i][j] = dp[i][j-2]
 *          2. 1次匹配，例如s='ab',p="ab*", 干掉*即可，dp[i][j] = dp[i][j-1]
 *          3. >1次匹配，例如s="abbb",p="ab*",dp[i][j] = dp[i-1][j]
 */
public class LC10 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        char[] sChs = s.toCharArray();
        char[] pChs = p.toCharArray();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        //全部置为false;
        for(int i = 0; i < sLen; i++){
            for(int j = 0; j < pLen; j++){
                dp[i][j] = false;
            }
        }
        //都为空字符串时是匹配的
        dp[0][0] = true;
        //如果s是空字符串，p是形如a*b*c*的情况
        for(int j = 1; j < pLen + 1; j++) {
            if(pChs[j - 1] == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for(int i = 1; i < sLen + 1; i++) {
            for(int j = 1; j < pLen + 1; j++) {
                //如果当前的字符相等，那么前面匹配则当前匹配
                if(sChs[i - 1] == pChs[j - 1] || pChs[j - 1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                //如果当前的p中的字符是'*'
                else if(pChs[j - 1] == '*') {
                    //s当前和p的前一个字符匹配
                    if(sChs[i - 1] == pChs[j - 2] || pChs[j - 2] == '.') {
                        //关键，有三种情况，分别对应
                        //p当前匹配0次，p当前匹配一次，p当前匹配多次
                        dp[i][j] = dp[i][j-2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        //如果s当前和p*前一个字符不匹配，可算作匹配0次
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[sLen][pLen];

    }
}
