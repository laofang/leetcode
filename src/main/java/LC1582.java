/**
 * Leetcode1582题，二进制矩阵中的特殊位置
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 遍历矩阵，遇到1进行判定
 * 2. 如果是特殊位置，记录累加，同时记录位置不在访问元素所在的行列
 */
public class LC1582 {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            if(rows[i] == 1) continue;
            for (int j = 0; j < mat[i].length; j++) {
                if(cols[j] == 1) continue;
                if(mat[i][j] == 1 && f(mat,i,j,rows.length,cols.length)) {
                    ans++;
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        return ans;
    }
    public boolean f(int[][] mat,int i,int j,int m,int n) {
        for(int jj = 0; jj < n; jj++) {
            if(jj == j) continue;
            if(mat[i][jj] == 1) return false;
        }
        for(int ii = 0; ii < m;ii++) {
            if(ii == i) continue;
            if(mat[ii][j] == 1) return false;
        }
        return true;
    }
}
