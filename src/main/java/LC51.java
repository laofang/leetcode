import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode51题，N皇后
 * 关键字：回溯
 * 主要思路：
 * 1. 经典回溯算法题
 * 2. 主要是斜线如何记录
 *      1. 左斜线，j-i相同的在同一左斜线
 *      2. 右斜线，j+i相同的在同一右斜线
 */
public class LC51 {
    public List<List<String>> solveNQueens(int n) {
        //记录列的情况
        boolean[] col = new boolean[n];
        //记录斜线的情况
        boolean[][] bias = new boolean[2][2 * n - 1];
        //索引代表行，值代表列
        int[] board = new int[n];
        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
        }
        List<List<String>> ans = new LinkedList<List<String>>();
        //回溯
        traceBack(col,bias,board,ans,0,n);
        return ans;
    }

    public void traceBack(boolean[] col,boolean[][] bias,int[] board,List<List<String>> ans,int curRow, int n) {
        //n行已经放好，记录答案
        if(curRow == n) {

            List<String> l = new ArrayList<>(n);
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < n ;j++ ) {
                    if(j == board[i]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            ans.add(l);
            return;
        }

        for (int i = 0; i < n; i++) {
            //列或斜已经有了棋子就继续
            if(col[i] || bias[0][i+curRow] || bias[1][i - curRow + n - 1]) {
                continue;
            }
            //放入棋子，并将其列与斜记录
            board[curRow] = i;
            col[i] = true;
            bias[0][i + curRow] = true;
            bias[1][i - curRow + n - 1] = true;

            traceBack(col,bias,board,ans,curRow + 1,n);
            //收回棋子，并取消列与斜的记录
            board[curRow] = -1;
            col[i] = false;
            bias[0][i + curRow] = false;
            bias[1][i - curRow + n - 1] = false;
        }
    }
}
