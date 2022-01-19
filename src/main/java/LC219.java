import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode219题，存在重复元素II
 * 关键字：数组、哈希、滑动窗口
 * 主要思路：
 * 1. 遍历，同时查找hash表中是否有相同
 * 2. 如果有相同就计算比较，记录距离更近的
 * 3. 再将新的加入hash表
 */
public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>(100000);
        for(int i = 0; i < nums.length; i++) {
            Integer preIndex = m.get(nums[i]);
            if(preIndex != null) {
                if(i - preIndex <= k) {
                    return true;
                }
            }
            m.put(nums[i],i);
        }
        return false;
    }
}
