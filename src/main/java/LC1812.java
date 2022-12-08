/**
 * Leetcode1812题，判断国际象棋棋盘中一个格子的颜色
 * 关键字：数学、字符串
 * 主要思路：
 * 1. 把'ab'，中的a='1'当作从0开始，b='a'当作从0开始
 * 2. 若a+b为奇数，对应白色格子；a+b为偶数，对应黑色格子
 */
public class LC1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - '1') + (coordinates.charAt(1) - 'a')) % 2 == 1;
    }
}
