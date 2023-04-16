/**
 * Leetcode766题，托普利茨矩阵
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 斜着访问一遍，与每次第一个元素进行比较即可
 */
public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int x = i;
            int y = 0;
            while( x < m && y < n) {
                if(matrix[x++][y++] != matrix[i][0]) return false;
            }
        }
        for (int j = 1; j < n; j++) {
            int x = 0;
            int y = j;
            while(x < m && y < n) {
                if(matrix[x++][y++] != matrix[0][j]) return false;
            }
        }
        return true;
    }
}
//todo, 逃课LC1157题，子数组中绝大多数的元素，困难，线段树