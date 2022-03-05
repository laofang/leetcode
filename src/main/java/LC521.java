/**
 * Leetcode521题，最长的特殊序列 I
 * 关键字：字符串
 * 主要思路：
 * 1. 如果两个字符串长度不等，就是较长字符串的长度
 * 2. 如果两个字符串长度相等
 *      1. 如果字符串相同，返回-1
 *      2. 如果字符串不同，返回任一长度
 */
public class LC521 {
    public int findLUSlength(String a, String b) {
        if(a.length() == b.length()) {
            return a.equals(b) ?  -1 : a.length();
        } else if(a.length() > b.length()) {
            return a.length();
        } else {
            return b.length();
        }
    }
}
