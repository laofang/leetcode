/**
 * Leetcode1816题，截断句子
 * 关键字：字符串、截取
 * 主要思路：
 * 1. 很简单，注意k大于单词数量的情况
 *
 */
public class LC1816 {
    public String truncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
            if(count == k) {
                count = i;
                break;
            }
        }
        if(k > count) {
            return s;
        }
        return s.substring(0,count);
    }
}
