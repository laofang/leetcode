import java.util.PriorityQueue;

/**
 * Leetcode407题，接雨水II
 * 关键字：优先队列、二维数组、木桶原理
 * 主要思路：
 * 先将最外层的柱子加入优先队列，然后出队最小的，对最小的四周进行访问，再把访问过的作为新的柱子加入队列，然后重复这个过程（出队最小的……）
 * 1. 木桶原理，首先找到最外层的柱子放入优先队列（最短的在最前面）
 * 2. 从最短的这个出发，向四周灌水
 *      1. 如果四周低于外围最短的柱子，把它灌到和最短的柱子一样高，计算存水量，然后将它当作新的柱子，加入队列，然后记录已访问过，避免重复访问
 *      2. 如果四周高于这个最短的柱子，那直接作为新的柱子加入队列，记录已访问过
 *      3. 将当前这个最短柱子出列
 */
public class LC407 {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        int[] toward = new int[]{1,0,-1,0,1};
        int ans = 0;

        for(int i = 0; i < heightMap.length; i++) {
            for(int j = 0; j < heightMap[i].length; j++) {
                if(i == 0 || i == heightMap.length - 1  || j == 0 || j == heightMap[i].length - 1) {
                    pq.add(new int[]{i,j,heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        while(!pq.isEmpty()) {
            int[] temp = pq.remove();
            for(int i = 0; i < toward.length - 1; i++) {
                int high = temp[2];
                int ni = temp[0] + toward[i];
                int nj = temp[1] + toward[i+1];
                if(ni >=0 && ni < heightMap.length && nj >= 0 && nj < heightMap[0].length && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if(heightMap[ni][nj] > high) {
//                        System.out.println(heightMap[ni][nj] + " " + high);
                        pq.add(new int[]{ni,nj,heightMap[ni][nj]});
                    } else {
                        ans += high - heightMap[ni][nj];
                        pq.add(new int[]{ni,nj,high});
                    }
                }
            }
        }
        return ans;
    }
}
