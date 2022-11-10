import java.util.Arrays;
import java.util.LinkedList;

/**
 * Leetcode864题，获取所有钥匙的最短路径
 * 关键字：位运算、广度优先搜索、数组、矩阵
 * 主要思路：
 * 1. 先找到起始位置和钥匙的数量，钥匙的数量通过一个整型的位来保存
 * 2. 广度优先搜索，每次如果用更少的步数，以同样的状态（也就是获得的钥匙的情况），到达同一个位置，更新此状态下到达此位置的步数，并入队
 * 3. 如果最终获取的钥匙数量和初始的相同，返回当前位置步数 + 1
 */
public class LC864 {
    int[] dit = new int[]{-1,0,1,0,-1};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int keyCnt = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        //记录某种获取钥匙的状态下，到达某个位置的最小步数
        int[][][] distance = new int[m][n][127];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(distance[i][j],Integer.MAX_VALUE);
                char ch = grid[i].charAt(j);
                if(ch == '@') {
                    queue.offer(new int[]{i,j,0});
                    distance[i][j][0] = 0;
                } else if(ch >= 'a' && ch <= 'z') keyCnt++;
            }
        }
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            int state = pos[2];
            int step = distance[i][j][state];
            for(int k = 0; k < dit.length - 1; k++) {
                int x = i + dit[k];
                int y = j + dit[k + 1];
                //超越边界
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                char ch = grid[x].charAt(y);
                //是墙
                if(ch == '#') continue;
                //是锁且没有钥匙
                if(ch >= 'A' && ch <= 'Z' && (state & (1 << (ch - 'A'))) == 0 ) continue;
                //如果是钥匙
                int nState = state;
                if(ch >= 'a' && ch <= 'z' && (nState = (state | (1 << (ch - 'a')))) == ((1 << keyCnt) - 1)) return step + 1;
                if(step + 1 >= distance[x][y][nState]) continue;
                distance[x][y][nState] = step + 1;
                queue.offer(new int[]{x,y,nState});
            }
        }
        return -1;
    }
}
