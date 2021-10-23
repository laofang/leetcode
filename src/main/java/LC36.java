/**
 * Leetcode36题,有效的数独
 * 关键字：数组
 * 主要思路：
 * 1. 每遍历一个数字，检查每行，每列，每块，然后记录每行，每列，每块情况
 * 2. 难点是找出块与i,j的关系，idx = i / 3 * 3 + j / 3;
 */
public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        //记录行，i记录行所引，j记录对应数字
        boolean[][] row = new boolean[10][10];
        //记录列
        boolean[][] col = new boolean[10][10];
        //记录块
        boolean[][] idx = new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //不是空格才进行判断
                if(board[i][j] != '.') {
                    //如果行列块已经存在当前数字，直接返回false;
                    if(row[i][board[i][j] - '0'] || col[j][board[i][j] - '0'] ||
                            idx[i / 3 * 3 + j / 3][board[i][j] - '0']) {
                        return false;
                    }
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    idx[i / 3 * 3 + j/3][board[i][j] - '0'] = true;
                }
            }
        }
        //不存在的情况返回true;
        return true;
    }
}
