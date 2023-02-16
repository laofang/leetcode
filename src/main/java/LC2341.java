/**
 * Leetcode2341题，数组能形成多少数对
 * 关键字：数组、哈希表、计数
 * 主要思路：
 * 1. 哈希表记录出现的次数，统计每个同一数字出现的次数除以2
 * 2. 统计出现的对数和总长度减去对数*2作为答案
 */
public class LC2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        int[] table = new int[101];
        for(int i = 0; i < nums.length; i++) {
            ans[0] -= table[nums[i]] / 2;
            ans[0] += ++table[nums[i]] / 2;
        }
        ans[1] = nums.length - 2 * ans[0];
        return ans;
    }
}
