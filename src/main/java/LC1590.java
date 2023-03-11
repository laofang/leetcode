import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1590题，使数组和能被P整除
 * 关键字：数组、哈希表、前缀和
 * 主要思路：
 * 1. 要知道两个余数相关的定理
 *  1. a % p = k，b % p = k，则有(a - b) % p = 0
 *  2. (a - b) % p = k，则有a % p = (b - k) % p
 */
public class LC1590 {
    public int minSubarray(int[] nums, int p) {
        Map<Long,Integer> map = new HashMap<>(1 << 16);
        long k = Arrays.stream(nums).mapToLong(value -> (long)value).sum() % p;
        if(k == 0) return 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++) {
            sum += nums[i];
            long rem = sum % p;
            long target = (sum + p - k) % p;
            Integer index = map.get(target);
            if(index != null) {
                ans = Math.min(ans,i - index);
            } else if(rem == k && i < nums.length - 1) {
                ans = Math.min(ans,i+1);
            }
            map.put(rem ,i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
