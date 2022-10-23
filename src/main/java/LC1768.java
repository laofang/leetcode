/**
 * Leetcode1768题，交替合并字符串
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 类似合并有序数组的算法。
 */
public class LC1768 {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while(i < word1.length() && j < word2.length()) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        while(i < word1.length()) {
            ans.append(word1.charAt(i++));
        }
        while(j < word2.length()) {
            ans.append(word2.charAt(j++));
        }
        return ans.toString();
    }
}
