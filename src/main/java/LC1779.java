/**
 * Leetcode1779题，找到最近的有相同X或Y坐标的点
 * 关键字：数组
 * 主要思路：
 * 1. 简单题，遍历，比较，记录，更新
 */
public class LC1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, minDis = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] != x && points[i][1] != y) continue;
            int dis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
            if(dis < minDis) {
                ans = i;
                minDis = dis;
            }
        }
        return ans;
    }
}
