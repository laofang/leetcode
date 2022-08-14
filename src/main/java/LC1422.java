/*
 * Leetcode1422题，分割字符串的最大得分
 * 关键字：字符串
 * 主要思路：
 * 1. 先统计出字符串中‘1‘的数量
 * 2. 再进行遍历，遇‘0‘，‘0‘的数量增长，遇‘1‘，‘1‘的数量减少
 * 3. 遍历过程中，获得最大得分值
 */
public class LC1422 {
    public int maxScore(String s) {
        char[] chs = s.toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;
        int max = 0;
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '1') oneCnt++;
        }
        for(int i = 0; i < chs.length-1; i++) {
            if(chs[i] == '0') {
                zeroCnt++;
            } else {
                oneCnt--;
            }
            max = Math.max(zeroCnt + oneCnt, max);
        } 
        return max;
    }
}
