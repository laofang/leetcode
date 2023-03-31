import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2367题，算术三元组的数目
 * 关键字：数组、哈希表、双指针、枚举
 * 主要思路：
 * 1. 只要遍历每一个数字，如果这个数组 num - diff 和 num + diff都存在，那就可以构成一个三元组
 */
public class LC2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
        }
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            int num1 = nums[i] - diff;
            int num2 = nums[i] + diff;
            if(map.get(num1) != null && map.get(num2) != null) {
                ans++;
            }
        }
        return ans;
    }
}
