import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2395题，和相等的子数组
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 哈希表记录已有的和，遍历查找已有的和是否二次出现
 */
public class LC2395 {
    public boolean findSubarrays(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length-1;i++) {
            int v = nums[i] + nums[i+1];
            if(map.get(v) != null) return true;
            map.put(v,1);
        }
        return false;
    }
}
