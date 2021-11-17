/**
 * Leetcode598题，范围求和
 * 关键字：二维数组、二维矩阵
 * 主要思路：
 * 1. 找到最小的边界，也就是最小的a和b
 * 2. 最后返回 a * b即可
 */
public class LC598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;
        //找到最小的边界a和b
        for(int i = 0; i < ops.length; i++) {
            minA = Math.min(ops[i][0],minA);
            minB = Math.min(ops[i][1],minB);
        }
        //最小边界乘积即是答案
        return minA * minB;
    }
}
