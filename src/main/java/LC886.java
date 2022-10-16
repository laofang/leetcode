/**
 * Leetcode886题，可能的二分法
 * 关键字：深度优先搜索、广度优先搜索、并查集、图
 * 主要思路：
 * 1. 对相互不喜欢的关系建立无向图。
 * 2. 然后进行深度优先搜索，并进行染色。
 * 3. 如果根节点的颜色是1，子节点的颜色就是2，反之相同。
 * 4. 如果遍历子节点时，子节点已经染过色，而且与根相同，这是分组存在矛盾，不可能二分。
 * 5. 所有节点遍历后，染色完毕，说明可以二分。
 */
public class LC886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length == 0) return true;
        int[][] graph = new int[n+1][n+1];
        int[] color = new int[n+1];
        //创建邻接表
        for(int i = 0; i < dislikes.length; i++) {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        for(int i = 1; i < n + 1; i++) {
            if (dfs(graph, i, color,0)) continue;
            return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph,int root,int[] color,int parentColor) {
        if(parentColor == 0) {
            if(color[root] == 0) color[root] = 1;
        } else {
            if (parentColor == color[root]) return false;
            if (color[root] == 0) color[root] = parentColor == 1 ? 2 : 1;
            else {
                return true;
            }
        }
        int[] cur = graph[root];
        for(int i = 1; i < color.length; i++) {
            if(graph[root][i] == 1) {
                if(dfs(graph,i,color,color[root]) == true) continue;
                else return false;
            }
        }
        return true;
    }
}
//todo,886题，中等，可能的二分法。使用的深度搜索加染色，效率比较低，可以进行进一步优化。