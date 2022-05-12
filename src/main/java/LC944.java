/**
 * Leetcode944题，删列造序
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 遍历每一列如果出现，后一个元素比前一个小，记录+1，再遍历下一列
 */
public class LC944 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
