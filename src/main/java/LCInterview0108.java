/**
 * Leetcode 面试题 01.08，零矩阵
 * 关键字：数组、哈希表、矩阵
 * 主要思路：
 * 1. 做过相同的题目，所以记得将0提升到第一行，第一列，但要注意[0][0]位置，要单独进行判断
 */
public class LCInterview0108 {
    public void setZeroes(int[][] matrix) {
        int fCol = 1;
        int fRow = 1;
        for(int i = 0; i < matrix[0].length;i++) {
            if(matrix[0][i] == 0) {
                fRow = 0;
                break;
            }
        }
        for(int i = 0; i < matrix.length;i++) {
            if(matrix[i][0] == 0) {
                fCol = 0;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++ ) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length;i++) {
            if(matrix[0][i] == 0) {
                for(int k = 0; k < matrix.length;k++) {
                    matrix[k][i] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length;i++) {
            if(matrix[i][0] == 0) {
                for(int k = 0; k < matrix[0].length;k++) {
                    matrix[i][k] = 0;
                }
            }
        }
        if(fCol == 0){
            for(int i = 0; i < matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }
        if(fRow == 0) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
