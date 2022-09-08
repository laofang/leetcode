/**
 * Leetcode667题，优美的排列II
 * 关键字：数组、数学
 * 主要思路：
 * 1. 数组[1,2,3,4,5,6]，满足k=1；数组[1,6,5,4,3,2,1]，满足k=2；数组[1,6,2,3,4,5]，满足k=3
 * 2. 先交叉获取前k个元素，前面一个，后面一个，反复
 * 3. 之后的元素，根据k的奇偶，进行正序排列，或倒倒序排列
 */
public class LC667 {
    public int[] constructArray(int n, int k) {
        int l = 1;
        int r = n;
        int[] ans = new int[n];
        for(int i = 0; i < k; i++) {
            ans[i] = i % 2 == 0 ? l++ : r--;
        }
        for(int i = k; i < ans.length; i++) {
            ans[i] = k % 2 == 1 ? l++ : r--;
        }
        return ans;
    }
}
