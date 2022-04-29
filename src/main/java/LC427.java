import structure.Node;

/**
 * Leetcode427题，建立四叉树
 * 关键字：树、数组、分治、矩阵
 * 主要思路：
 * 1. 使用递归+前缀和
 * 2. 一块矩阵，可以分为四个部分
 * 3. 如果某一部分值完全相同，即对应一个叶子节点，叶子节点的值就是这个相同的值
 * 4. 如果某一部分的值不完全相同，重复2过程，直到完全相同
 */
public class LC427 {
    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] sum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + grid[i-1][j-1];
            }
        }

        return dfs(sum,0,0,n,n);
    }
    public int getSum(int[][] sum,int x0,int y0,int x1,int y1) {
        return sum[x1][y1] - sum[x0][y1] - sum[x1][y0] + sum[x0][y0];
    }
    public Node dfs(int[][] sum,int x0,int y0,int x1,int y1) {
        int s = getSum(sum,x0,y0,x1,y1);
        if(s == 0) {
            return new Node(false,true);
        }
        if(s == (x1 - x0) * (y1 - y0)) {
            return new Node(true,true);
        }
        Node node = new Node(
                true,
                false,
                dfs(sum,x0,y0,(x0 + x1) / 2, (y0 + y1) / 2),
                dfs(sum,x0,(y1+y0) / 2,(x1 + x0) / 2, y1),
                dfs(sum,(x0 + x1) / 2,y0,x1,(y0 + y1) / 2),
                dfs(sum,(x0+x1) / 2, (y0 + y1) / 2, x1,y1)
        );
        return node;
    }
}
