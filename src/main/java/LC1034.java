import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Leetcode1034题，边界着色
 * 关键字：广度优先搜索、队列
 * 主要思路：
 * 1. 要访问连通分量中的所有元素，从给定的元素开始，广度优先搜索，先将给定的元素入队
 * 2. 只要队列不空，就出队，并对出队元素做如下处理
 *      1. 访问出队元素的上下左右四个方向的元素
 *      2. 如果四个方向中的元素，存在是连通分量内，且没访问过的，就入队
 *      3. 如果存在一个或多余一个元素是非连通分量元素，说明当前出队元素是连通分量边界元素，记录，之后要涂色
 * 3. 将记录需要涂色位置的元素涂色
 */
public class LC1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //图的行
        int r = grid.length;
        //图的列
        int l = grid[0].length;
        //上下左右四个方向增量
        int[] directions = new int[]{1,0,-1,0,1};
        //是否访问过的记录
        int[][] flags = new int[grid.length][grid[0].length];
        //连通分量的颜色
        int oColor = grid[row][col];
        //需要涂色的元素
        Set<int[]> set = new HashSet<>();
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //将给定元素位置入队
        queue.offer(new int[]{row,col});
        //打上入过队的标记
        flags[row][col] = 1;
        //队列不空就广度优先搜索
        while(!queue.isEmpty()) {
            //出队
            int[] center = queue.poll();
            //对四个方向的节点判断，并对同一连通分量没访问过的进行入队
            for(int i = 0; i < directions.length -1; i++) {
                int x = center[0] + directions[i];
                int y = center[1] + directions[i + 1];
                //当前元素如果是非连通分量，中心元素则是边界
                if (x < 0 || y < 0 || x >= r || y >= l || grid[x][y] != oColor) {
                    set.add(new int[]{center[0], center[1]});
                    //未访问过，且在同一连通分量的，进行入队
                } else if (flags[x][y] != 1) {
                    //打上入队标记
                    flags[x][y] = 1;
                    //入队
                    queue.offer(new int[]{x, y});
                }
            }
        }
        //对记录过的边界位置进行上色
        for(int[] temp : set) {
            grid[temp[0]][temp[1]] = color;
        }
        return grid;
    }
}
