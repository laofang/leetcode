/**
 * Leetcode1219题，黄金矿工
 * 关键字：矩阵、回溯、哈希
 * 主要思路：
 * 1. 遍历每一个元素，如果不是0，就从此位置除出发进行回溯
 * 2. 深度优先搜索，遍历过的要进行记录
 * 3. 遍历过程中与max记录对比，有更大的就进行更新
 */
public class LC1219 {
    private int[] directs = new int[]{-1,0,1,0,-1};
    public int getMaximumGold(int[][] grid) {
        int[] max = new int[1];
        boolean[][] logs = new boolean[grid.length][grid[0].length];
        int sum = 0;
        //遍历每一个元素
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                //如果当前值不是0，就进行深度优先搜索
                if(grid[i][j] != 0) {
                    traceBack(new int[]{i,j},grid,max,sum,logs);
                }
            }
        }
        return max[0];
    }

    /**
     * 回溯
     * @param cur 当前位置
     * @param grid 总图
     * @param max 最大值
     * @param sum 当前的和
     * @param logs 遍历过的记录
     */
    public void traceBack(int[] cur,int[][] grid,int[] max,int sum,boolean[][] logs) {
        //x,y如果超越边界，或当前位置的值为0，或者已经访问过，就返回
        if(cur[0] < 0 || cur[1] < 0 ||
                cur[0] >= grid.length || cur[1] >= grid[0].length ||
                grid[cur[0]][cur[1]] == 0 || logs[cur[0]][cur[1]]) {
            return;
        }
        for(int i = 0; i < directs.length-1; i++) {
            //下一个点
            sum += grid[cur[0]][cur[1]];
            max[0] = Math.max(sum,max[0]);
            logs[cur[0]][cur[1]] = true;
            cur[0] += directs[i];
            cur[1] += directs[i+1];
            //回溯
            traceBack(cur,grid,max,sum,logs);
            //恢复
            cur[0] -= directs[i];
            cur[1] -= directs[i+1];
            logs[cur[0]][cur[1]] = false;
            sum -= grid[cur[0]][cur[1]];
        }
    }
}
