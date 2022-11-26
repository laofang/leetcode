/**
 * Leetcode434题，字符串中的单词数
 * 关键字：字符串
 * 主要思路：
 * 1. 每次循环，先跳过所有空格，再跳过所有非空格，所有非空格构成一个单词，答案加一，然后再进行下一次循环
 */
public class LC434 {
    public int countSegments(String s) {
        int ans = 0;
        int i = 0;
        char[] chs = s.toCharArray();
        while(i < chs.length) {
            while (i < chs.length && chs[i] == ' ') ++i;
            if(i == chs.length) break;
            while(i < chs.length && chs[i] != ' ') ++i;
            ++ans;
        }
        return ans;
    }
}
