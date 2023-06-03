import java.util.Arrays;

/**
 * Leetcode1030题，距离顺序排列矩阵单元格
 * 关键字；几何、数组、数学、排序、矩阵
 * 主要思路：
 * 1. 先构造，再排序
 */
public class LC1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][2];
        int index = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans[index][0] = i;
                ans[index][1] = j;
                index++;
            }
        }
        Arrays.sort(ans,(e1, e2) -> {
            int e1Dis = Math.abs(e1[0] - rCenter) + Math.abs(e1[1] - cCenter);
            int e2Dis = Math.abs(e2[0] - rCenter) + Math.abs(e2[1] - cCenter);
            return e1Dis - e2Dis;
        });
        return ans;
    }
}
