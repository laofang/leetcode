import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1380题，矩阵中的幸运数
 * 关键字：矩阵、二维数组
 * 主要思路：
 * 1. 记录行最小和列最大的数
 * 2. 行最小的，列最大的映射到一个二维数组计数
 * 3. 如果同一个位置访问两次，这个位置的数就是幸运数
 */
public class LC1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] board = new int[m][n];

        int[][] cols = new int[n][2];

        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < m; i++) {

            int max = Integer.MAX_VALUE;
            int maxJ = 0;

            for(int j = 0; j < n;j++) {
                if(cols[j][1] == 0 || matrix[i][j] > cols[j][1]) {
                    cols[j][1] = matrix[i][j];
                    cols[j][0] = i;
                }
                if(i == m - 1 ) {
                    board[cols[j][0]][j]++;
                    if(board[cols[j][0]][j] == 2) {
                        list.add(matrix[cols[j][0]][j]);
                        return list;
                    }
                }
                if(matrix[i][j] < max) {
                    maxJ = j;
                    max = matrix[i][j];
                }
            }

            board[i][maxJ]++;

            if(board[i][maxJ] == 2) {
                list.add(matrix[i][maxJ]);
                return list;
            }

        }


        return list;
    }
}
