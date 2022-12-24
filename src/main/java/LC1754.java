/**
 * Leetcode1754题，构造字典序最大的合并字符串
 * 关键字：贪心、双指针、字符串
 * 主要思路：
 * 1. 每次取字典序最大的字符串的首字母，重复这个过程
 */
public class LC1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        while(word1.length() > 0 && word2.length() > 0) {
            if(word1.compareTo(word2) >= 0) {
                ans.append(word1.charAt(0));
                word1 = word1.substring(1);
            } else {
                ans.append(word2.charAt(0));
                word2 = word2.substring(1);
            }
        }
        if(word1.length() == 0) {
            ans.append(word2);
        } else {
            ans.append(word1);
        }
        return ans.toString();
    }
}
