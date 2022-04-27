import java.util.*;

/**
 * Leetcode417题，太平洋大西洋水流问题
 * 关键字：深度优先搜索、广度优先搜索、数组、矩阵
 * 主要思路：
 * 1. 使用广度优先搜索，从太平洋边缘向内搜索，对符合条件的位置进行标记
 * 2. 同样，再从大西洋的边缘向内搜索，如果可以流入大西洋的位置，也是上面标记的位置，则加入答案列表
 * ps: 可以不用自定义类型的，使用数组就行，当时想到可能用equals比较，其实没有必要，都用数组进行记录了
 */
public class LC417 {
    int[] directs = new int[]{-1,0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] logs = new boolean[m][n];



        queue.offer(new Point(0,0));
        logs[0][0] = true;
        for(int i = 1; i < m; i++) {
            queue.offer(new Point(i,0));
            logs[i][0] = true;
        }
        for(int i = 1; i < n; i++) {
            queue.offer(new Point(0,i));
            logs[0][i] = true;
        }

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < directs.length-1; i++) {
                int x = p.x + directs[i];
                int y = p.y + directs[i+1];
                if(x >= 0 && y >= 0 && x < m
                        && y < n && !logs[x][y]
                        && heights[x][y] >= heights[p.x][p.y]) {
                    logs[x][y] = true;
                    queue.offer(new Point(x,y));
                }
            }
        }


        boolean[][] atlanticLogs= new boolean[m][n];
        queue.offer(new Point(m-1,n-1));
        atlanticLogs[m-1][n-1] = true;
        for(int i = 0; i < m - 1; i++) {
            queue.offer(new Point(i,n-1));
            atlanticLogs[i][n-1] = true;
        }
        for(int i = 0; i < n - 1; i++) {
            queue.offer(new Point(m-1,i));
            atlanticLogs[m-1][i] = true;
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(logs[p.x][p.y]) {
                List<Integer> list = new ArrayList<>(2);
                list.add(p.x);
                list.add(p.y);
                ans.add(list);
            }
            for (int i = 0; i < directs.length-1; i++) {
                int x = p.x + directs[i];
                int y = p.y + directs[i+1];
                if(x >= 0 && y >= 0 && x < m
                        && y < n && !atlanticLogs[x][y]
                        && heights[x][y] >= heights[p.x][p.y]) {
                    atlanticLogs[x][y] = true;
                    queue.offer(new Point(x,y));
                }
            }
        }
        return ans;
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
