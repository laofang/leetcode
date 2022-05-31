/**
 * Leetcode190题，颠倒二进制位
 * 关键字：位运算、分治法
 * 主要思路：
 * 1. 从n的低位开始遍历，将每一位赋予答案的高位递减
 */
public class LC190 {
    public int reverseBits(int n) {
        int flag = 1;
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int cur = (flag << i) & n;
            cur = cur >>> i;
            ans = ans | (cur<<(31 - i));
        }
        return ans;
    }
}
