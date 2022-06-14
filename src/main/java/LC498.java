/**
 * Leetcode498题，对角线遍历
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 主要是模拟的思路
 * 2. 斜上遍历的时候，有两种越界情况，(1) j > n 和 (2)i < 0
 * 3. 斜下遍历的时候，也有两种越界情况，(1) i > m 和 (2)j < 0
 */
public class LC498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = 0;
        int ans[] = new int[m*n];
        int cur = 0;
        boolean up = true;
        int[] v = new int[]{-1,1};

        while(cur < ans.length) {
            ans[cur++] = mat[i][j];

            i = i + v[0];
            j = j + v[1];
            if(i < 0 || i >= m || j < 0 || j >= n) {
                if(j == n) {
                    i = i + 2;
                    j--;

                } else if(i < 0) {
                    i++;
                }

                if(i == m) {
                    j = j + 2;
                    i--;
                } else if(j < 0) {
                    j++;
                }
                int temp = v[0];
                v[0] = v[1];
                v[1] = temp;
            }

        }
        return ans;
    }
}
