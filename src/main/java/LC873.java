import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode873题，最长的斐波那契子序列的长度
 * 关键字；数组、哈希表、动态规划
 * 主要思路：
 * 1. 使用动态规划的方法，dp[i][j]表示的是arr[i],arr[j]构成的一对数，arr[j]是这个斐波那契数列的第几个数（从3计数）
 * 2. dp[j][index] = dp[i][j] + map.get(arr[i]+arr[j])
 */
public class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int next = arr[i] + arr[j];
                Integer index = map.get(next);
                if(index != null) {
                    dp[j][index] = dp[i][j] + 1;
                    if(dp[j][index] > max) {
                        max = dp[j][index];
                    }
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}
