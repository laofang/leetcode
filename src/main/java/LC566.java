/**
 * Leetcode566题，重塑矩阵
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 将原矩阵，按顺序放入新的数组，新的数组大小和原矩阵大小要一致
 */
public class LC566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r * c != mat.length * mat[0].length) return mat;
        if(r == mat.length && c == mat[0].length) return mat;
        int[][] ans = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = mat[x][y];
                if(y == mat[0].length - 1) {
                    ++x;
                    y = 0;
                } else {
                    ++y;
                }
            }
            if(x == mat.length) break;
        }
        return ans;
    }
}
//todo，逃课LC1632题，困难，思路矩阵转换后的秩，并查集+拓扑排序