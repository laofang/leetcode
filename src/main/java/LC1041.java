/**
 * Leetcode1041题，困于环中的机器人
 * 关键字：数学、字符串、模拟
 * 主要思路：
 * 1. 如果成环，最多四遍就会成环；或者不成环。如果一遍回到原点，或者方向与初始不同，也都能成环。
 */
public class LC1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int d = 0;
        for(char ch : instructions.toCharArray()) {
            if(ch == 'G'){
                switch (d) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }
            } else {
                if(ch == 'L') {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }
        }
        if(x == 0 && y == 0) return true;
        return d != 0;
    }
}
