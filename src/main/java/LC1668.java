/**
 * Leetcode1668题，最大重复子字符串
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 不断增加word的次数，直到sequence不再包含
 */
public class LC1668 {
    public int maxRepeating(String sequence, String word) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb.toString())) {
            ++cnt;
            sb.append(word);
        }
        return cnt;
    }
}
