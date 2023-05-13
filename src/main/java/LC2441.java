import java.util.HashMap;

/**
 * Leetcode2441题，与对应负数同时存在的最大正整数
 * 关键字：数组、哈希表、双指针、排序
 * 主要思路：
 * 1. 采用哈希表的做法，可以参考力扣第一题
 */
public class LC2441 {
    public int findMaxK(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int i = 0; i < nums.length; i++) {
            if(map.get(0 - nums[i])!= null) {
                ans = Math.max(Math.abs(nums[i]),ans);
            } else {
                map.put(nums[i],1);
            }
        }
        return ans;
    }
}
