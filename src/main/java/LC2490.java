/**
 * Leetcode2490题，回环句
 * 关键字：字符串
 * 主要思路：
 * 1. 按题意测试，取模测试最后和第一个
 */
public class LC2490 {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        for(int i = 0; i < s.length; i++) {
            if(s[i % s.length].charAt(s[i % s.length].length() - 1) != s[(i+1) % s.length].charAt(0)) return false;
        }
        return true;
    }
}
