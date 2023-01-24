/**
 * Leetcode1828题，统计一个圆中点的数目
 * 关键字：几何、数组、数学
 * 主要思路：
 * 1. 针对每一个查询的圆，遍历每一个点
 * 2. 如果点到圆心的距离，小于等于半径。则在园内，对应的答案加1
 */
public class LC1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            for(int j = 0; j < points.length; j++) {
                int detX = points[j][0] - queries[i][0];
                int detY = points[j][1] - queries[i][1];
                if(detX * detX + detY * detY <= queries[i][2] * queries[i][2]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
