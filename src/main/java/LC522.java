/**
 * Leetcode522题，最长特殊序列II
 * 关键字：数组、哈希表、双指针、字符串、排序
 * 主要思路：
 * 1. 暴力检测，遍历每个字符串，是否是其他字符串子序列
 * 2. 如果不是子序列，尝试更新结果
 */
public class LC522 {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for(int i = 0; i < strs.length;i++) {
            int j = 0;
            for(; j < strs.length;j++) {
                if(i != j && strs[i].length() <= strs[j].length()) {
                    boolean flag = isSubSequence(strs[i],strs[j]);
                    if(flag) break;
                }
            }
            if(j == strs.length) {
                ans = Math.max(ans,strs[i].length());
            }
        }
        return ans;
    }
    public boolean isSubSequence(String sStr,String lStr) {
        char[] sChs = sStr.toCharArray();
        char[] lChs = lStr.toCharArray();
        int s = 0,l = 0;
        while(s < sChs.length && l < lChs.length) {
            while(l < lChs.length && lChs[l] != sChs[s]) l++;
            if(l == lChs.length) break;
            s++;
            l++;
        }
        return s == sChs.length;
    }
}
