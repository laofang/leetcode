/**
 * Leetcode812题，最大三角形面积
 * 关键字：几何、数组、数学
 * 主要思路：
 * 1. 已知三角形三点坐标，求三角形面积S的公式：
 *      S = 1/2 * | X1 * (Y1 - Y3) + X2 * (Y3 - Y1) * X3 * (Y1 - Y2) |
 */
public class LC812 {
    public double largestTriangleArea(int[][] points) {
        int max = 0;
        int n = points.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    double area = 0.5 * Math.abs(points[i][0] * (points[j][1] - points[k][1])
                            + points[j][0] * (points[k][1] - points[i][1])
                            + points[k][0] * (points[i][1] - points[j][1]));
                    ans = Math.max(ans,area);
                }
            }
        }
        return ans;
    }
}
