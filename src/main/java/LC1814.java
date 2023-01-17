import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1814题，统计一个数组中好对子的数目
 * 关键字：数组、哈希表、数学、计数
 * 主要思路：
 * 1. a + rev(b) = b + rev(a)
 * 2. a - rev(a) = b - rev(b)
 * 3. 最后就是求具有 相同的 num - rev(num) 差值的数字个数，并选出两个进行全组合，答案就是共有的组合数之和
 */
public class LC1814 {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            int key = num - rev(num);
            int val = map.getOrDefault(key,0);
            map.put(key,val + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            long val = entry.getValue();
            ans += (val % MOD) * ((val - 1) % MOD) / 2 % MOD;
            ans %= MOD;
        }
        return ans;
    }
    public int rev(int num) {
        int ans = 0;
        while(num > 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }
}
