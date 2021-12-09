/**
 * Leetcode794题，有效的井字游戏
 * 关键字：位运算、字符串、游戏
 * 主要思路：
 * 1. 从两个方面来判断当前棋盘状态是否有效
 *      1. 数量上
 *          count('X') - count('O') == 0 || count('X') - count('O') == 1
 *      2. 胜利的情况
 *          1. X胜利
 *              'O'不存在三连
 *              count('X') - count('O') == 1
 *              1. 有一个连续三'X'，
 *              2. 也有可能有两个连续三'X'，且count('X') - count('O') == 1
 *          2. O胜利
 *              'X'不存在三连
 *              count('X') - count('O') == 0
 *
 */
public class LC794 {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        //x: 01 //o:02  // ' ' : 04
        // 右斜线和左斜线  000|000|：  3、2、1列：000|000|000|  3、2、1行：000|000|000
        int victoryBit = 0;
        for(int i = 0; i < board.length;i++) {
            for(int j = 0; j < board[i].length(); j++) {
                //统计棋子数量
                char ch = board[i].charAt(j);
                if(ch == 'X') {
                    xCount++;
                } else if(ch == 'O') {
                    oCount++;
                }
                //统计连续三个情况
                int x = getBit(ch);
                //行的情况记录在低九位，每三位表示一行
                victoryBit = victoryBit | x<<(i*3);
                //列的情况记录在中九位，每三位表示一列
                victoryBit = victoryBit | x<<(j+3) * 3;
                //斜线情况记录在高六位，每三位表示一斜线
                if(i == j) {
                    //左右斜线情况记录在高六位的低三位
                    victoryBit = victoryBit | x <<(6 * 3);
                }
                if(i + j == 2) {
                    //右左斜线情况记录在高六位的高三位
                    victoryBit = victoryBit | x <<(7 * 3);
                }

            }
        }
        //棋子数量关系
        int xMinusO = xCount - oCount;
        if(xCount - oCount > 1 || oCount > xCount) {
            return false;
        }
        xCount = 0;
        oCount = 0;
        while(victoryBit != 0) {
            //查看每三位的情况
            int flag = victoryBit & 7;
            //三位连续或操作如果结果是1，说明X三连
            if(flag == 1 ) {
                xCount++;
                //结果是2，说明是O三连
            } else if(flag == 2) {
                oCount++;
            }
            //再向右移三位，继续判断
            victoryBit = victoryBit>>3;
        }
        //x胜利
        if(xCount > 0) {
            //X胜利时，X的数量比O多一个，且O不能再三连
            if(xMinusO != 1 || oCount > 0) {
                return false;
            }
        }
        //o胜利
        else if (oCount > 0) {
            //O胜利时，X的数量和O的数量相等，且X不能再三连
            if(xCount > 0 || xMinusO != 0) {
                return false;
            }
        }
        return true;
    }
    public int getBit(char ch) {
        switch (ch) {
            case 'X':
                return 1;
            case 'O':
                return 2;
            case ' ':
                return 4;
            default:
                return 0;
        }
    }
}
