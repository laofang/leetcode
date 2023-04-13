import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2404题，出现最频繁的偶数元素
 * 关键字：数组、哈希表、计数
 * 主要思路：
 * 1. 哈希表统计每个偶数出现的次数，选出最小且次数最多的
 */
public class LC2404 {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(2000);
        int cntMax = 0;
        int ans = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                int cnt = map.getOrDefault(num, 0);
                cnt++;
                map.put(num, cnt);
                if (cnt > cntMax) {
                    ans = num;
                    cntMax = cnt;
                }
            }
        }
        return ans;
    }
}
