/**
 * Leetcode1732题，找到最高海拔
 * 关键字：数组、前缀和
 * 主要思路：
 * 1. 假设第i个节点的海拔高度为a[i]，gain[i] = a[i] - a[i-1]
 * 2. 所以每个节点的高度，a[i] = a[i-1] + gain[i], 依次求出，并记录最大值
 */
public class LC1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for(int i = 0; i < gain.length; i++) {
            cur += gain[i];
            max = Math.max(cur,max);
        }
        return max;
    }
}
