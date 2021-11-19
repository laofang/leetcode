import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode397题，整数替换
 * 关键字：递归、记忆化搜索
 * 主要思路：
 * 1. 递归搜索
 * 2. 注意2^31-1
 * 3. 提高效率可以增加记忆化搜索
 */
public class LC397 {
    Map<Integer,Integer> m = new HashMap<>();
    public int integerReplacement(int n) {
        if(m.get(n) != null) {
            return m.get(n);
        }
        if(n <= 1) {
            return 0;
        }
        //偶数只有/2的选择
        if( n % 2 == 0) {
            int ans = 1 + integerReplacement(n / 2);
            m.put(n,ans);
        } else{
            //奇数有+1，-1的选择
            if(n == Integer.MAX_VALUE) {
                int ans =2 + Math.min(integerReplacement(n/2 + 1),integerReplacement(n / 2));
                m.put(n,ans);
                return m.get(n);
            }
            int ans = 1 + Math.min(integerReplacement(n-1),integerReplacement(n + 1));
            m.put(n,ans);
        }
        return m.get(n);
    }
}
