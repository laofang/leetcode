/**
 * Leetcode2559题，统计范围内的元音字符串数
 * 关键字：数组、字符串、前缀和
 * 主要思路：
 * 1. 前缀和，预先求出前k个元素中元音字符串数
 * 2. 区间搜索，根据起止位置，做差计算
 */
public class LC2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] sumPre = new int[words.length];
        int curCnt = 0;
        for(int i = 0; i < words.length; i++) {
            if(isYuan(words[i].charAt(0)) && isYuan(words[i].charAt(words[i].length()-1))) {
                curCnt++;
            }
            sumPre[i] = curCnt;
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = queries[i][0] == 0 ? sumPre[queries[i][1]] : sumPre[queries[i][1]] - sumPre[queries[i][0] - 1];
        }
        return ans;
    }
    public boolean isYuan(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
