import java.util.Arrays;

/**
 * Leetcode1798题，你能构造出连续值的最大数目
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 先对数组进行排序
 * 2. 从1开始按顺序尝试，如果当前coin不大于当前值，那必然可以构成当前值，同时可以构成cur + coin的值，反之就结束
 */
public class LC1798 {
    public int getMaximumConsecutive(int[] coins) {
        int cur = 0;
        Arrays.sort(coins);
        for(int coin : coins) {
            if(coin > cur + 1) break;
            cur += coin;
        }
        return cur + 1;
    }
}
