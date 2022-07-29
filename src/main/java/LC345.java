/**
 * Leetcode345题，翻转字符串中的元音字母
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 前后两个指针，走到同是元音的位置交换
 */
public class LC345 {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while(l < r) {
            while(l < r && !isYuan(chs[l])) {
                l++;
            }
            while(l < r && !isYuan(chs[r])) {
                r--;
            }
            if(l >= r) break;
            char temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++;
            r--;
        }
        return new String(chs);
    }
    public boolean isYuan(char ch) {
        switch (ch) {
            case 'a':
            case 'A':
            case 'o':
            case 'O':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'u':
            case 'U':
                return true;
        }
        return false;
    }
}
