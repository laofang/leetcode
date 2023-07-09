/**
 * Leetcode1351题，统计有序矩阵中的负数
 * 关键字：数组、二分查找、矩阵
 * 主要思路：
 * 1. 可以用二分法找到每行第一个负数，在这个位置之后都是负数
 * 2. 我这里没用二分法，每行遍历，找到第一个负数
 */
public class LC1351 {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] < 0) {
                    ans += grid[i].length - j;
                    break;
                }
            }
        }
        return ans;
    }
}
