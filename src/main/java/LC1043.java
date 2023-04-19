/**
 * Leetcode1043题，分隔数组以得到最大和
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 递归算法，dfs(i)就时从[0,i]满足题意的最大值，从后向前先遍历取[1,k]个长度，在递归dfs(i-k,i-1)
 * 2. 上面递归会超时，加一个记忆化搜索的缓存，存储遍历过的dfs(i)的值
 */
public class LC1043 {
    int[] cache;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        cache = new int[arr.length];
        return dfs(arr,arr.length-1,k);
    }
    public int dfs(int[] arr, int i, int k) {
        if(i < 0) {
            return 0;
        }
        if(cache[i] != 0) return cache[i];
        int ans = 0;
        int max = 0;
        for(int j = i; j > i - k && j >= 0; j--) {
            max = Math.max(arr[j],max);
            ans = Math.max(ans,dfs(arr,j - 1,k) + (i - j + 1) * max);
        }
        cache[i] = ans;
        return ans;
    }
}
