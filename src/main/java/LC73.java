/**
 * Leetcode73题，矩阵置零
 * 关键字：矩阵、数组
 * 主要思路：
 * 1. 出现0的位置对应的首行和首列位置置为0，如果matrix[i][j] = 0,则matrix[i][0] = 0,matrix[0][j] = 0;
 * 2. 但要注意先记录首行首列初始是否有0
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        //首行首列是否原本就有0
        int row = 0;
        int col = 0;
        //首列是否存在0
        for(int i = 0; i < matrix.length;i++) {
            if(matrix[i][0] == 0) {
                col = 1;
            }
        }
        //首行是否存在0
        for(int i = 0; i < matrix[0].length;i++) {
            if(matrix[0][i] == 0) {
                row = 1;
            }
        }
        //将出现0的位置，对应首行，首列的位置置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //遍历每个行首，如果行首为0，则将此行置为0
        for(int i = matrix.length-1; i > 0;i--) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < matrix[i].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //遍历每个列首，如果列首为0，则将此列置为0
        for(int i = matrix[0].length - 1; i >= 0;i--) {
            if(matrix[0][i] == 0) {
                for(int j =0; j<matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //如果首行有0，则将首行置为0
        if(row == 1) {
            for(int i = 0; i < matrix[0].length;i++) {
                matrix[0][i] = 0;
            }
        }
        //如果首列有0，则将首列置为0
        if(col == 1) {
            for(int i = 0; i < matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
