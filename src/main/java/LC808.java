import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode808题，分汤
 * 关键字：数学、动态规划、概率与统计
 * 主要思路：
 * 1. 首先找到边界条件，当A分完，或B分完，或同时分完的，对于给定的概率
 * 2. 然后进行深度优先搜索，需要加个缓存
 */
public class LC808 {
    Map<String,Double> cache = new HashMap<>();
    public double soupServings(int n) {
        if(n > 3375) return 1;
        return dfs(n,n);
    }
    public double dfs(int i, int j) {
        String key = new StringBuilder().append(i).append(" ").append(j).toString();
        Double value = cache.get(key);
        if(value != null) return value;

        if(i == 0 && j > 0) return 1;
        if(i == 0 && j == 0) return 0.5;
        if(i > 0 && j == 0) return 0;

        double ans = 0;
        ans += dfs(Math.max(0,i - 100), j);
        ans += dfs(Math.max(0,i - 75), Math.max(0,j - 25));
        ans += dfs(Math.max(0,i - 50), Math.max(0,j - 50));
        ans += dfs(Math.max(0,i - 25), Math.max(0,j - 75));

        ans *= 0.25;
        cache.put(key, ans);
        return ans;
    }
}
