/**
 * Leetcode52题，N皇后II
 * 关键字：回溯
 * 主要思路：
 * 1. 基本和51题一样，只是最后记录答案要记录答案数量
 */
public class LC52 {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[][] bias = new boolean[2][2 * n - 1];
        int[] board = new int[n];
        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
        }
        int[] ans = new int[1];
        traceBack(col,bias,board,ans,0,n);
        return ans[0];
    }
    public void traceBack(boolean[] col,boolean[][] bias,int[] board,int[] ans,int curRow, int n) {

        if(curRow == n) {
            ans[0]++;
//            List<String> l = new ArrayList<>(n);
//            for (int i = 0; i < board.length; i++) {
//                StringBuilder sb = new StringBuilder();
//                for(int j = 0 ; j < n ;j++ ) {
//                    if(j == board[i]) {
//                        sb.append('Q');
//                    } else {
//                        sb.append('.');
//                    }
//                }
//                l.add(sb.toString());
//            }
//            ans.add(l);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(col[i] || bias[0][i+curRow] || bias[1][i - curRow + n - 1]) {
                continue;
            }
            board[curRow] = i;
            col[i] = true;
            bias[0][i + curRow] = true;
            bias[1][i - curRow + n - 1] = true;

            traceBack(col,bias,board,ans,curRow + 1,n);

            board[curRow] = -1;
            col[i] = false;
            bias[0][i + curRow] = false;
            bias[1][i - curRow + n - 1] = false;
        }
    }
}
