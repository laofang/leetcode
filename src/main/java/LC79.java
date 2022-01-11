import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode79题，单词搜索
 * 关键字：二维矩阵、二维数组、回溯
 * 主要思路：
 * 1. 先遍历所有字母，将给定字符串的首字母相同的位置都入队
 * 2. 对队内每一个元素进行回溯，如果能深度搜索到给定单词，则成功
 * 3. 否则失败
 */
public class LC79 {
    private int[] direction = new int[] {1,0,-1,0,1};
    public boolean exist(char[][] board, String word) {

        //队列
        Queue<int[]> queue = new LinkedList<>();
        int[][] flag = new int[board.length][board[0].length];
        //将第一个字母出现的位置入队
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            //标记已访问
            flag[current[0]][current[1]] = 1;
            //回溯，当前位置首字母，是否能找到给定单词
            boolean ans = traceBack(board,current,flag,1,word);
            if(ans) {
                return true;
            }
            //如果当前位置首字母不行，要恢复标记
            flag[current[0]][current[1]] = 0;
        }
        return false;
    }

    public boolean traceBack(char[][] board,int[] curent,int[][] flag,int wIndex,String word) {
        if(wIndex == word.length()) {
            return true;
        }
        //四个方向查找给定的第下一个字母
        for (int i = 0; i < direction.length - 1; i++) {
            int x = curent[0] + direction[i];
            int y = curent[1] + direction[i+1];
            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(wIndex) != board[x][y] || flag[x][y] == 1) {
                continue;
            }
            flag[x][y] = 1;
            boolean ans = traceBack(board,new int[]{x,y},flag,wIndex+1,word);
            flag[x][y] = 0;
            if(ans) {
                return true;
            }
        }
        return false;
    }
}
