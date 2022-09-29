/**
 * Leetcode 面试题 01.09,字符串轮转
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 首先要保证s1和s2的长度相等
 * 2. 轮转是对称的，s1如果是s2轮转得到的，那么s2也是s1的轮转结果
 * 3. 如果s1是s2轮转的，则会有s1是s2+s2的子串，这是充分必要条件，前提是s1.length() == s2.length()
 *
 */
public class LCInterview0109 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return (s2+s2).contains(s1);
    }
}
