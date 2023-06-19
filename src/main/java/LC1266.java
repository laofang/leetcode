/**
 * Leetcode1266题，访问所有点的最小时间
 * 关键字：几何、数组、数学
 * 主要思路：
 * 1. 每次加上相邻两点绝对值的相对值
 */
public class LC1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(points[i][1] - points[i-1][1]),
                    Math.abs(points[i][0] - points[i-1][0]));
        }
        return ans;
    }
}
