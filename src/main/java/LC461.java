/**
 * Leetcode461题，汉明距离
 * 关键字：位运算
 * 主要思路：
 * 1. 先算两数异或，再统计异或结果为1的位数
 */
public class LC461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int test = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if( (z & (test << i)) != 0) ++ans;
        }
        return ans;
    }
}
//todo 逃课Leetcode1799题，困难，N次操作后的最大分数和，动态规划+状态压缩
