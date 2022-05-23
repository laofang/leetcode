import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode217题，存在重复元素
 * 关键字：数组、哈希表、排序
 * 主要思路：
 * 1. 哈希表判断是否存在重复元素
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.get(num) != null) return true;
            map.put(num,num);
        }
        return false;
    }
}
