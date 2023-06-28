/**
 * Leetcode1304题，和为零的N个不同整数
 * 关键字：数组、数学
 * 主要思路：
 * 1. 如果n是奇数范围则是[-n/2...,0,...n/2],如果n是偶数范围则是[-n/2...,-1,1,...n/2]
 */
public class LC1304 {
    public int[] sumZero(int n) {
        int start = -n / 2;
        int[] ans = new int[n];
        int index = 0;
        for(int i = start; i < start + n; i++) {
            if(i >= 0 && n % 2 == 0) {
                ans[index++] = i+1;
            } else {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
