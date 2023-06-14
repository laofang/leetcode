import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2475题，数组中不等三元组的数目
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 先哈希表统计每个元素数量，然后前面的数量 * 当前元素数量 * 之后的元素数量，再求和
 */
public class LC2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer,Integer> cntMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int cnt = cntMap.getOrDefault(nums[i],0);
            cntMap.put(nums[i],cnt+1);
        }
        int ans = 0;
        int pre = 0;
        for(Map.Entry<Integer,Integer> e : cntMap.entrySet()) {
            ans += pre * e.getValue() * (nums.length - pre - e.getValue());
            pre += e.getValue();
        }
        return ans;
    }
}
