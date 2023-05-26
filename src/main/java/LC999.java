/**
 * Leetcode999题，可以被一步捕获的棋子数
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 找到车的位置
 * 2. 再从车的位置，进行上下左右四个方向的搜索，如果第一个碰到的是'p'，最终答案进行累加
 */
public class LC999 {
    public int numRookCaptures(char[][] board) {
        int[] rPos = new int[2];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'R') {
                    rPos[0] = i;
                    rPos[1] = j;
                    break;
                }
            }
        }
        int ans = 0;
        int i = rPos[0] - 1;
        while(i >= 0 && board[i][rPos[1]] != 'B') {
            if(board[i][rPos[1]] == 'p') {
                ans++;
                break;
            }
            i--;
        }
        i = rPos[0] + 1;
        while(i < board.length && board[i][rPos[1]] != 'B') {
            if(board[i][rPos[1]] == 'p') {
                ans++;
                break;
            }
            i++;
        }
        int j = rPos[1] - 1;
        while(j >= 0 && board[rPos[0]][j] != 'B') {
            if(board[rPos[0]][j] == 'p') {
                ans++;
                break;
            }
            j--;
        }
        j = rPos[1] + 1;
        while(j < board[0].length && board[rPos[0]][j] != 'B') {
            if(board[rPos[0]][j] == 'p') {
                ans++;
                break;
            }
            j++;
        }
        return ans;
    }
}
