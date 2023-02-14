import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1124题，表现良好的最长时间段
 * 关键字：栈、数组、哈希表、前缀和、单调栈
 * 主要思路：
 * 1. 使用前缀和，维护一段时间，劳累的天数与不劳累天数的差值
 */
public class LC1124 {
    public int longestWPI(int[] hours) {
        int ans = 0, s = 0;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < hours.length; ++i) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                ans = i + 1;
            } else if (pos.containsKey(s - 1)) {
                ans = Math.max(ans, i - pos.get(s - 1));
            }
            pos.putIfAbsent(s, i);
        }
        return ans;
    }
}
