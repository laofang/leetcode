/**
 * Leetcode28,实现strStr()
 * 关键字：字符串，模式匹配，字符串匹配
 * 主要思路：
 * 1. 首先想到学过的KMP算法，但有些记不清了，先用暴力方法实现
 * 2. 主要用了暴力匹配的方式
 */
public class LC28 {
    public int strStr(String haystack, String needle) {
        char[] hayChars = haystack.toCharArray();
        char[] needChars = needle.toCharArray();
        if(hayChars.length == 0 && needChars.length == 0) {
            return 0;
        }
        for (int i = 0; i < hayChars.length; i++) {
            int j = i,k = 0;
            while(j < hayChars.length && k < needChars.length && hayChars[j] == needChars[k]) {
                j++;
                k++;
            }
            if(k == needChars.length) {
                return i;
            }
        }
        return -1;
    }
    //TODO KMP算法
}
