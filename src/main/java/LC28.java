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

    /**
     * KMP模式匹配算法
     * KMP算法写的是真难受，理解之后感觉还可以
     */
    public int strStrKMP(String haystack, String needle) {
        if(needle.length()==0) {
            return 0;
        }

        int[] next = getNext(needle);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //如果相等，p串向后移动
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //如果不相等
            else if(j > 0 ){
                //如果j不是0，没匹配，就找前一个
                j = next[j-1];
                //如果j不是0，且没匹配，i是不变的
                i--;
            }
            if(needle.length() == j) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 计算p字符串的next数组
     * next[j]的值意味着p串的0~j的字符前缀和后缀最大匹配字符个数
     */
    public int[] getNext(String str) {
        int[] next = new int[str.length()];
        if(str.length() > 0) {
            next[0] = 0;
        }
        int j = 0;
        char[] p = str.toCharArray();
        for (int i = 1; i < p.length; i++) {
            //这里可以理解，如果p[i]和p[j]不等，p[i]要看前一个字符的匹配情况。就像使用next数组一样，再跳到之前的位置对比。
            //这里要格外注意
            while(j > 0 && p[i] != p[j]) {
                //跳到前一个位置
                j = next[j-1];
            }
            //如果相等，next[i] = j + 1
            if(p[i] == p[j]) {
                next[i] = j + 1;
                j++;
            }
        }
        return next;
    }
}
