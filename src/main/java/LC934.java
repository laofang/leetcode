import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode934题，最短的桥
 * 关键字：深度优先搜索、广度优先搜索、数组、矩阵
 * 主要思路：
 * 1. 先遍历grid找到一个岛的一块，然后从这块广度优先搜索，遍历整个岛，并将边缘入队
 * 2. 再从边缘队列进行广度优先搜索进行扩张，每轮扩张结果加1，直到扩张到与另一个岛相交
 */
public class LC934 {
    int[] dirs = new int[] {1,0,-1,0,1};
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] flag = new int[m][n];
        Queue<int[]> edges = new LinkedList<>();
        //遍历找到一个岛，并将岛的边缘入队(edges)
        for(int i = 0; i < grid.length; i++) {
            boolean findLand = false;
            for(int j = 0; j < grid[i].length; j++) {
                //找到了一个岛
                if(grid[i][j] == 1) {
                    findLand = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    flag[i][j] = 1;
                    //广度优先搜索，遍历整个岛，并将边缘入队
                    while(!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        grid[pos[0]][pos[1]] = 2;
                        boolean joinEdge = false;
                        //当前位置的四个方向
                        for(int k = 0; k < dirs.length - 1; k++) {
                            int x = pos[0] + dirs[k];
                            int y = pos[1] + dirs[k + 1];
                            //如果新的位置超过边界，继续
                            if(x < 0 || y < 0 || x >= m || y >= n) continue;
                            //如果新的位置已经遍历加入过队列过，继续
                            if(flag[x][y] == 1) continue;
                            //说明是边缘，加入edges队列
                            if(grid[x][y] == 0) {
                                //加入过edges就不要再加了，避免重复
                                if(!joinEdge) {
                                    edges.offer(new int[]{pos[0],pos[1]});
                                    joinEdge = true;
                                }
                            } else {
                                if(flag[x][y] != 1) {
                                    queue.offer(new int[]{x,y});
                                    flag[x][y] = 1;
                                }
                            }
                        }

                    }
                    break;
                }
            }
            if(findLand) break;
        }
        //每轮扩张使用的边缘，用一个挡板隔开，每次拆除一个挡板，结果增加1
        edges.offer(new int[]{-1,-1});
        // edges.forEach(e -> System.out.println(e[0]+ " " +e[1]));
        //从边缘进行扩张，直到碰到另一个岛位置，看一共扩张多少轮
        int ans = 0;
        while(!edges.isEmpty()) {
            int[] pos = edges.poll();
            //拆除挡板，上轮边缘使用完毕，结果+1
            if(pos[0] == -1 && pos[1] == -1) {
                ++ans;
                edges.offer(pos);
                continue;
            }
            //遍历四个方向
            for(int i = 0; i < dirs.length - 1; i++) {
                int x = pos[0] + dirs[i];
                int y = pos[1] + dirs[i+1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                //访问过就继续
                if(flag[x][y] == 1) continue;
                //说明与另一个岛相交
                if(grid[x][y] == 1) return ans;
                //如果是空的进行本次扩张，同时加入到下次使用的边缘
                if(grid[x][y] == 0) {
//                    grid[x][y] = 2;
                    edges.offer(new int[]{x,y});
                    flag[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
