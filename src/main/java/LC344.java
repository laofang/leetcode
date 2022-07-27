/**
 * Leetcode344题，翻转字符串
 * 关键字：递归、双指针、字符串
 * 主要思路：
 * 1. 双指针，对称交换
 */
public class LC344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
}
