import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1260题，二维网络迁移
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 把二维数组一维化
 * 2. 然后可以看作将一维数组，从(len-k)位置到最后的元素，整体移动到数组的头部
 * 3. 再将一维数组二维化即可
 */
public class LC1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        k = k % len;

        int index = len - k;
        List<List<Integer>> ans = new ArrayList<>(m);
        for(int i = 0; i < m;i++) {
            List<Integer> t = new ArrayList<>(n);
            for(int j = 0; j < n;j++) {
                int idx = (index + j) % len;
                t.add(grid[idx/n][idx%n]);
            }
            index = index + n;
            ans.add(t);
        }
        return ans;
    }
}
