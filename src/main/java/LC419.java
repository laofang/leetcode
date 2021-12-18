/**
 * Leetcode419题，甲板上的战舰
 * 关键字：数组
 * 主要思路：
 * 从左向右遍历，每次只记左上的'X'即可。
 * 如果当前board[i][j] == 'X'，且board[i-1][j] != 'X',board[i][j-1] != 'X',说明这是左上的'X'，可以用来表示一艘战舰
 */
public class LC419 {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //如果当前位置是'X'
                if(board[i][j] == 'X') {
                    //左边也是'X'，说明已经记录过
                    if(i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }
                    //上边也是'X'，说明已经记录过
                    if(j > 0 && board[i][j-1] == 'X') {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
