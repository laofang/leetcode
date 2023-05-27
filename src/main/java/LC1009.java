/**
 * Leetcode1009题，十进制整数的反码
 * 关键字：位运算
 * 主要思路：
 * 1. 就是位运算，按位反转
 */
public class LC1009 {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }
        int cur = 1;
        int index = 31;
        while(((cur << index) & n) == 0) {
            index--;
        }
        int ans = 0;
        System.out.println(index);
        while(index >= 0) {
            if(((cur << index) & n) == 0) {
                ans = ans | (cur << index);
            }
            index--;
        }
        return ans;
    }
}
