/**
 * Leetcode1903题，字符串中的最大奇数
 * 关键字：贪心、数学、字符串
 * 主要思路：
 * 1. 从低位开始遍历，当前位是奇数，那从开始到当前的数字，就是最大奇数
 */
public class LC1903 {
    public String largestOddNumber(String num) {
        for(int i = num.length() - 1; i >= 0; i--) {
            if( (num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
