/**
 * LCP50题，宝石补给
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 模拟勇者间的宝石交换
 */
public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < operations.length; i++) {
            int x = operations[i][0];
            int y = operations[i][1];
            int val = gem[x] / 2;
            gem[x] -= val;
            gem[y] += val;
        }
        for(int i = 0; i < gem.length; i++) {
            max = Math.max(gem[i],max);
            min = Math.min(gem[i],min);
        }
        return max - min;
    }
}
