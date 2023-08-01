/**
 * Leetcode1572题，矩阵对角线元素的和
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 对角线元素累加，如果边长是奇数，注意中心元素重复累加，需要减掉
 */
public class LC1572 {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++) {
            ans += mat[i][i];
            ans += mat[i][mat.length - 1 - i];
        }
        if(mat.length % 2 == 1) {
            int index = mat.length / 2;
            ans -= mat[index][index];
        }
        return ans;
    }
}
