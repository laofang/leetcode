/**
 * Leetcode2000题，反转单词前缀
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 将前缀反转+后面的字符串
 */
public class LC2000 {
    public String reversePrefix(String word, char ch) {
        return new StringBuilder(word.substring(0,word.indexOf(ch)+1)).reverse().append(word.substring(word.indexOf(ch)+1)).toString();
    }
}
