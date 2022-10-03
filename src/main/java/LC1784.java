/**
 * Leetcode1784题，检查二进制字符串字段
 * 关键字；字符串
 * 主要思路：
 * 1. 题意描述的不清晰，题意的含义是首字母是1，且连续的1只有一个（1个1也算连续），所以出现0后再出现1就是非法
 * 2. 出现0记录，之后出现1返回false，否则返回true
 */
public class LC1784 {
    public boolean checkOnesSegment(String s) {
        boolean has0 = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                has0 = true;
            }
            if(s.charAt(i) == '1' && has0 == true) {
                return false;
            }
        }
        return true;
    }
}
