import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode874题，模拟行走机器人
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 模拟
 */
public class LC874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dic = new int[]{-1,0,1,0,-1};
        int cur = 1;
        int[] curPos = new int[]{0,0};
        Set<Integer> obsSet = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++) {
            obsSet.add(obstacles[i][0] * 100000 + obstacles[i][1]);
        }
        int ans = 0;
        for(int i = 0; i < commands.length; i++) {
            if(commands[i] == -1) {
                cur = cur == 3 ? 0 : cur + 1;
            } else if(commands[i] == -2) {
                cur = cur == 0 ? 3 : cur - 1;
            } else {
                for(int j = 0; j < commands[i]; j++) {
                    int x = curPos[0] + dic[cur];
                    int y = curPos[1] + dic[cur+1];
                    int key = x * 100000 + y;
                    if(obsSet.contains(key)) break;
                    curPos[0] = x;
                    curPos[1] = y;
                    ans = Math.max(x * x + y * y,ans);
                }

            }
        }
        return ans;
    }
}
