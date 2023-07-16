/**
 * Leetcode1323题，6和9组成的最大数字
 * 关键字：贪心、数学
 * 主要思路：
 * 1. 从前向后遍历，如果是6就换成9
 */
public class LC1323 {
    public int maximum69Number (int num) {
        String str = num + "";
        char[] chs = str.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '6') {
                chs[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(chs));
    }
}
