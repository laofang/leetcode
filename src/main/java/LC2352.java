import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2352题，相等行列对
 * 关键字：数组、哈希表、矩阵、模拟
 * 主要思路：
 * 1. 使用Hash表，行列转化为字符串进行对比
 */
public class LC2352 {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
                sb.append("-");
            }
            int cnt = map.getOrDefault(sb.toString(),0);
            map.put(sb.toString(),cnt+1);
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i]);
                sb.append("-");
            }
            int cnt = map.getOrDefault(sb.toString(),0);
            ans += cnt;
        }
        return ans;
    }
}
