/**
 * Leetcode441题，排列硬币
 * 关键字：数学、二分法
 * 抓药思路：
 * 1. 采用二分法，找到小于等于指定值中的最大值，这应该算简单题里比较有难度的问题
 */
public class LC441 {
    public int arrangeCoins(int n) {
        long l = 0;
        long r = n;
        while(l <= r) {
            long half = (l + r) / 2;
            long val = (1 + half) * half / 2;
            if(val > n) {
                r = half - 1;
            } else {
                l = half + 1;
            }
        }
        return (int)r;
    }
}
//todo 逃课，Leetcode1687题，从仓库到码头运输箱子，困难，动态规划
