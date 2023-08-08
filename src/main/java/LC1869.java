/**
 * Leetcode1869题，哪种连续字符串更长
 * 关键字：字符串
 * 主要思路：
 * 1. 分别统计连续1的最长串和连续0的最长串，再进行对比
 */
public class LC1869 {
    public boolean checkZeroOnes(String s) {
        int i = 0;
        int oCnt = 0;
        int zCnt = 0;
        char[] chs = s.toCharArray();
        while(i < chs.length) {
            char ch = chs[i];
            int cnt = 0;
            if(ch == '0') {
                while(i < chs.length && chs[i] == ch ) {
                    i++;
                    cnt++;
                }
                zCnt = Math.max(zCnt,cnt);
            } else {
                while(i < chs.length && chs[i] == ch )
                {
                    i++;
                    cnt++;
                }
                oCnt = Math.max(oCnt,cnt);
            }
        }
        return oCnt > zCnt;
    }
}
