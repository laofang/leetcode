/**
 * Leetcode1332题，删除回文子序列
 * 关键字：字符串、回文、子序列
 * 主要思路：
 * 1. 因为只有'a','b'两种字符，所以最多删两次就可以（先删一种，再删另一种，都属于子序列）
 * 2. 由于至少有一个字符，最少删除一次，所以答案只有两种可能，一次或两次
 * 3. 一次的情况就是整个字符串是回文串，除此之外都是两次
 * 4. 所以只要判断当前字符串是不是回文串即可
 */
public class LC1332 {
    public int removePalindromeSub(String s) {
        int l = -1;
        int r = s.length();
        while(l < r) {
            if(s.charAt(++l) != s.charAt(--r)) break;
        }
        return l >= r ? 1 : 2;
    }
}
