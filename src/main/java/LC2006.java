/**
 * Leetcode2006题，差的绝对值为k的数对数目
 * 关键字：数组、哈希、统计
 * 主要思路：
 * 1. 遍历，每一个数去查找遍历过的，有没有与它相差k的数
 * 2. 加上相差k的数的数量进行统计即可
 */
public class LC2006 {
    public int countKDifference(int[] nums, int k) {
        int[] arrays = new int[101];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] - k <= 0 ? 0 : arrays[nums[i] - k];
            ans += nums[i] + k > 100 ? 0 : arrays[nums[i] + k];
            arrays[nums[i]]++;
        }
        return ans;
    }
}
