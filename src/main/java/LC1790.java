/**
 * Leetcode1790题，仅执行一次字符串交换能否使两个字符串相等
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 双指针，从左到右，找到第一个不同的位置，如果没有，直接返回true
 * 2. 再从右到左找到第一个不同的位置，如果这两个位置交叉不相等，返回false
 * 3. 如果交叉相等，再看两指针之间有没有不同字符，如果存在不同的，返回false,否则返回true
 */
public class LC1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int l = 0;
        int r = s1.length() - 1;
        while(l <= r) {
            if(s1.charAt(l) != s2.charAt(l)) break;
            l++;
        }
        if(l > r) return true;
        while(r > l) {
            if(s1.charAt(r) != s2.charAt(r)) break;
            r--;
        }
        if(l == r) return false;
        if(s1.charAt(l) == s2.charAt(r) && s1.charAt(r) == s2.charAt(l)) {
            for(l = l + 1; l < r; l++) {
                if(s1.charAt(l) != s2.charAt(l)) return false;
            }
            return true;
        }
        return false;
    }
}
