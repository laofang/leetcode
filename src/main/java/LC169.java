import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode169题，多数元素
 * 关键字：数组、哈希表、分治、计数、排序
 * 主要思路：
 * 1. map记录数字出现的次数
 * 2. 数字出现的次数 > n / 2，当前数字就是答案
 */
public class LC169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num,0);
            if(count != -1) {
                ++count;
                if(count > nums.length / 2) {
                    ans = num;
                    break;
                }
                map.put(num,count);
            }
        }
        return ans;
    }
}
