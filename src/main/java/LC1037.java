/**
 * Leetcode1037题，有效的回旋镖
 * 关键字：几何、数组、数学
 * 主要思路：
 * 1. 先判断三个点各不相同
 * 2. 再比较不同的两点的斜率
 * 注意：
 * 1. 求斜率时，斜率为0的情况
 */
public class LC1037 {
    public boolean isBoomerang(int[][] points) {
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) return false;
            }
        }

        int detX1 = points[1][0] - points[0][0];
        int detX2 = points[2][0] - points[0][0];
        if(detX1 == 0 && detX2 == 0) {
            return false;
        } else if(detX1 == 0 || detX2 == 0) {
            return true;
        } else {
            return (double)(points[1][1] - points[0][1]) / detX1 != (double)(points[2][1] - points[0][1]) / detX2;
        }
    }
}
