/**
 * Leetcode680题，验证回文字串II
 * 关键字：贪心、双指针、字符串
 * 主要思路：
 * 1. 主要是有一个字符导致不回文的情况
 * 2. 一旦对应位置的字符，如chs[l]和chs[r]不相等，就判断[l+1,r] 和 [l,r-1]这两个是否存在回文
 */
public class LC680 {
    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(chs[l] != chs[r]) break;
            l++;
            r--;
        }
        if(l >= r) return true;
        int left = l + 1;
        int right = r;
        while(left < right) {
            if(chs[left] != chs[right]) break;
            left++;
            right--;
        }
        if (left >= right) return true;
        left = l;
        right = r - 1;
        while(left < right) {
            if(chs[left] != chs[right]) break;
            left++;
            right--;
        }
        return left >= right;
    }
}
//todo,逃课LC1039题，多边形三角剖分的最低得分，是一类动态规划的经典题