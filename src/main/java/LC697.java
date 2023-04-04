/**
 * Leetcode697题，数组的度
 * 关键字：数组哈希表
 * 主要思路：
 * 1. 先求出众数，再对每一个满足众数的数字，取左右两个，算出距离，最后取最短的距离
 */
public class LC697 {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int n = nums.length;
        int[] table = new int[50000];
        for(int i = 0; i < n; i++) {
            table[nums[i]]++;
            degree = Math.max(degree,table[nums[i]]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < table.length; i++) {
            if(table[i] == degree) {
                int l = 0;
                while(l < n && nums[l++] != i) continue;
                int r = n - 1;
                while(r >= 0 && nums[r--] != i) continue;
                ans = Math.min(ans,r - l + 3);
            }
        }
        return ans;
    }
}
