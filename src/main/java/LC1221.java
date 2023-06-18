/**
 * Leetcode1221题，分割平衡字符串
 * 关键字：贪心、字符串、计数
 * 主要思路：
 * 1. 遍历，统计到当前位置的'L'和'R'的数量
 * 2. 如果'L'和'R'数量相同，答案递增
 */
public class LC1221 {
    public int balancedStringSplit(String s) {
        int lCnt = 0;
        int rCnt = 0;
        int ans = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'L') {
                lCnt++;
            } else {
                rCnt++;
            }
            if(lCnt == rCnt) ans++;
        }
        return ans;
    }
}
