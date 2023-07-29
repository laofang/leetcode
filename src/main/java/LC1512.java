/**
 * Leetcode1512题，好数对的数目
 * 关键字：数组、哈希表、数学、计数
 * 主要思路：
 * 1. 计数累加
 */
public class LC1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] table = new int[101];
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans += table[nums[i]];
            table[nums[i]]++;
        }
        return ans;
    }
}
