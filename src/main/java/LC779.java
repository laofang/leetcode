/**
 * Leetcode779题，第k个语法符号
 * 关键字：位运算、递归、数学
 * 主要思路：
 * 1. 使用递归算法，第n行，第k列的字符，取决于第n-1行，(k+1)/2个字符和当前k的位置
 * 2. 如果上一个字符是'0'，当前奇数位，则当前值为0，否则为1；如果上一个字符是'1'，则相反
 */
public class LC779 {
    public int kthGrammar(int n, int k) {
        if(n == 1 && k == 1) return 0;
        int pre = kthGrammar(n-1,(k+1) / 2);
        if(pre == 0) {
            return k % 2 == 1 ? 0 : 1;
        } else {
            return k % 2 == 1 ? 1 : 0;
        }
    }
}
