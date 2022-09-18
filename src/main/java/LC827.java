import java.util.*;

/**
 * Leetcode827题，最大人工岛
 * 关键字：广度优先搜索、深度优先搜索、并查集、数组、矩阵
 * 主要思路:
 * 1. 先通过广度优先搜索，求出每个岛的面积，进行编号存储
 * 2. 再遍历每个不为陆地的位置，尝试翻转，求出四周的总体面积，更新得到的最大面积
 */
public class LC827 {
    int[] direct = new int[] {0,-1,0,1,0};
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] flags = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer,Integer> numToArea = new HashMap<>();
        int num = 1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                //对一块新岛进行遍历，广度优先搜索
                if(flags[i][j] == 0 && grid[i][j] == 1) {
                    flags[i][j] = num;
                    queue.offer(new int[]{i,j});
                    int area = 1;
                    //遍历连续的一块岛，累计岛的面积并编号存储
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for(int k = 0; k < direct.length - 1; k++) {
                            int[] next = new int[]{cur[0] + direct[k],cur[1] + direct[k + 1]};
                            if(next[0] < 0 || next[1] < 0 || next[0] >= m || next[1] >= n) continue;
                            if(flags[next[0]][next[1]] == 0 && grid[next[0]][next[1]] == 1) {
                                flags[next[0]][next[1]] = num;
                                queue.offer(new int[]{next[0],next[1]});
                                area++;
                            }
                        }
                    }
                    numToArea.put(num,area);
                    num++;
                }
            }
        }

        if(numToArea.size() == 0) return 1;
        int ans = numToArea.get(1);
        Set<Integer> numSet = new HashSet<>();
        //对每个不为1的地方，尝试变为1，然后根据四周岛屿编号求面积，并更新最大面积
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int sum = 1;
                if(grid[i][j] == 0) {
                    for(int k = 0; k < direct.length - 1; k++) {
                        int[] next = new int[] {i + direct[k], j + direct[k+1]};
                        if(next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n ) {
                            numSet.add(flags[next[0]][next[1]]);
                        }
                    }
                    for(int number : numSet) {
                        if(number != 0) sum += numToArea.get(number);
                    }
                    numSet.clear();
                    ans = Math.max(ans,sum);
                }
            }
        }
        return ans;
    }
}
