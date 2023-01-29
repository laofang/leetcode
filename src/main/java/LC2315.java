/**
 * Leetcode2315题，统计星号
 * 关键字：字符串
 * 主要思路：
 * 1. 遍历每个字符，如果当前字符是'|'，如果当前不在区间，更新为在区间；如果当前在区间，更新为不在区间
 * 2. 如果当前字符是'*'，而且不在区间，则更新增加统计
 */
public class LC2315 {
    public int countAsterisks(String s) {
        boolean inArea = false;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '|') inArea = !inArea;
            if(ch == '*' && !inArea) ++ans;
        }
        return ans;
    }
}
