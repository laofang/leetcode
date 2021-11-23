/**
 * Leetcode65题，有效数字
 * 关键字：DFA(有限状态机）、表驱动
 * 主要思路：
 * 1. 构造有限状态机，然后以表驱动实现（大学的时候，编译原理课程做过这个）
 */
public class LC65 {
    //row 对应9种状态
    //col 分别对应：blank  +/-  0~9  e/E  dot  Other
    //value 不同状态下，遇到不同的字符转移到何种状态
    public int[][] stateMachine = new int[][]{
            {0,1,2,-1,6,-1},
            {-1,-1,2,-1,6,-1},
            {8,-1,2,4,3,-1},
            {8,-1,3,4,-1,-1},
            {-1,7,5,-1,-1,-1},
            {8,-1,5,-1,-1,-1},
            {-1,-1,3,-1,-1,-1},
            {-1,-1,5,-1,-1,-1},
            {8,-1,-1,-1,-1,-1}
    };
    public int result = 0b00101100;
    public boolean isNumber(String s) {
        int state = 0;
        for(char ch : s.toCharArray()) {
            int id = exec(ch);
            if(id == -1) {
                return false;
            }
            state = stateMachine[state][id];
            if(state == -1) {
                return false;
            }
        }
        return (result & (1 << state)) > 0;
    }

    public int exec(char ch) {
        switch (ch) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case 'e':
            case 'E':
                return 3;
            case '.':
                return 4;
            default:
                if(ch >= 48 && ch <=57) {
                    return 2;
                }

        }
        return -1;
    }
}
