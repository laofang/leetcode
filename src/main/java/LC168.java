/**
 * Leetcode168题，Excel表列名称
 * 关键字：数字、字符串
 * 主要思路：
 * 1. S = a0 * 26^n + a1 * 26 ^ (n-1) + …… + an * 26^0
 * 2. 每次循环求出26^0的系数，% 26 即可，然后减去求出的系数，再除26进行循环
 */
public class LC168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0) {
            int k = columnNumber % 26;
            int c = 0;
            if(k == 0) {
                sb.append('Z');
                c = 26;
            } else {
                sb.append((char)('A' - 1 + k));
                c = k;
            }
            columnNumber = (columnNumber - c) / 26;
        }
        return sb.reverse().toString();
    }
}
