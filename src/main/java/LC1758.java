/**
 * Leetcode1758题，生成交替二进制字符串的最少操作数
 * 关键字：字符串
 * 主要思路：
 * 1. 两种010101，和101010两种去对比s，不同最少的那个的不同数量就是答案
 */
public class LC1758 {
    public int minOperations(String s) {
        char t = '0';
        int a = 0, b = 0;
        for(char ch : s.toCharArray()) {
            if(ch == t) ++a;
            else ++b;
            t = t == '0' ? '1' : '0';
        }
        return Math.min(a,b);
    }
}
