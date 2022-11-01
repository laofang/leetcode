/**
 * Leetcode1662题，检查两个字符串数组是否相等
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 就是按照字符串的字符依次对比，这样效率还可以
 */
public class LC1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0,m = 0;
        int j = 0,n = 0;
        while(i < word1.length && j < word2.length) {
            char[] chs1 = word1[i].toCharArray();
            char[] chs2 = word2[j].toCharArray();
            while(m < chs1.length && n < chs2.length) {
                if(chs1[m] != chs2[n]) return false;
                m++;
                n++;
            }
            if(m == chs1.length) {
                ++i;
                m = 0;
            }
            if(n == chs2.length) {
                ++j;
                n = 0;
            }
        }
        if(i < word1.length) {
            if(m < word1[i].length()) return false;
        }
        if(j < word2.length) {
            if(n < word2[j].length()) return false;
        }
        return true;
    }
}
