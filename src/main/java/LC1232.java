/**
 * Leetcode1232题，缀点成线
 * 关键字：几何、数组、数学
 * 主要思路：
 * 1. 就是求两点斜率，两点斜率都相同，那就是在一条直线上
 */
public class LC1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int detX = coordinates[1][0] - coordinates[0][0];
        int detY = coordinates[1][1] - coordinates[0][1];
        Double k = detX != 0 ? ((double) detY) / detX : null;
        for(int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0] - coordinates[i-1][0];
            int y = coordinates[i][1] - coordinates[i-1][1];
            if(k == null && x == 0) continue;
            if(k!=null && k == (double) y / x) continue;
            return false;
        }
        return true;
    }
}
