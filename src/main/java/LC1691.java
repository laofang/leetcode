import java.util.Arrays;

/**
 * Leetcode1691题，堆叠长方体的最大高度
 * 关键字：数组、动态规划、排序
 * 主要思路：
 * 1. 首先要证明，长方体a[w1,l1,h1]可以放在b[w2,l2,h2]上，一定存在w1<=w2 且l1 <= l2 且 h1 <= h2
 * 2. 再用动态规划，把第i个长方体，尝试作底，遍历每个之前的高度，如果可以，记录更新最高的可能
 * 3. 可以参考LC300题，最长递增子序列
 */
public class LC1691 {
    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids,(c1,c2)->{
            if(c1[0] != c2[0]) return c1[0] - c2[0];
            if(c1[1] != c2[1]) return c1[1] - c2[1];
            return c1[2] - c2[2];
        });
        int ans = 0;
        int[] dp = new int[cuboids.length];
        for(int i = 0; i < cuboids.length;i++) {
            for(int j = 0; j < i; j++) {
                if(cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
