import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode1637题，两点之间不包含任何点的最宽垂直区域
 * 关键字：数组、排序
 * 主要思路：
 * 1. 就是排序，取相邻横坐标差值的最大值，这应该是简单题难度，不配中等题
 */
public class LC1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(e -> e[0]));
        int max = 0;
        for(int i = 1; i < points.length; i++) {
            int width = points[i][0] - points[i-1][0];
            max = Math.max(width,max);
        }
        return max;
    }
}
