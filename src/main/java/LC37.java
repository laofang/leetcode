/**
 * Leetcode37题，解数独
 * 关键字：二维数组，回溯
 * 主要思路：
 * 1. 就是非空点尝试，成功继续，不成功回溯；
 * 2. 主要是结束条件，当走到最后一个i=8,j=8的时候结束
 * 3. 由于题干写明只有唯一解，则只记录一次到i=8,j=8的情况
 */
public class LC37 {
    public void solveSudoku(char[][] board) {

        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] idx = new boolean[10][10];
        char[][] res = new char[9][9];
        //当前数独的情况
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    idx[i / 3 * 3 + j/3][board[i][j] - '0'] = true;
                }
            }
        }
        //回溯算法
        traceBack(board,row,col,idx,0,0,res);
        //将结果赋予board;
        for (int k = 0; k <board.length ; k++) {
            for (int l = 0; l <board[k].length ; l++) {
                board[k][l] = res[k][l];
            }
        }
    }
    //回溯算法
    public void traceBack(char[][] board,boolean[][] row,boolean [][] col,boolean[][]idx,int i, int j,char[][] res) {

        //检查寻找可以操作的点，按从前到后，再下一行的顺序，来找空格的位置
        while(board[i][j] != '.') {
            if(j < 8) {
                j++;
            } else if(i < 8) {
                i++;
                j = 0;
            } else {
                //i=8，j=8 且 board[8][8]不是空格，说明找到了一个解
                for (int k = 0; k <board.length ; k++) {
                    for (int l = 0; l <board[k].length ; l++) {
                        res[k][l] = board[k][l];
                    }
                }
                return;
            }
        }
        //尝试可能值
        for (int k = 1; k <= 9 ; k++) {
            //剪枝
            if(row[i][k] || col[j][k] || idx[i / 3 * 3 + j/3][k]) {
                continue;
            }
            //尝试新的可能的值
            board[i][j] =(char)('0' + k);
            row[i][k] = true;
            col[j][k] = true;
            idx[i / 3 * 3 + j / 3][k] = true;
            traceBack(board,row,col,idx,i,j,res);
            //回溯
            board[i][j] = '.';
            row[i][k] = false;
            col[j][k] = false;
            idx[i / 3 * 3 + j / 3][k] = false;
        }

    }
}
