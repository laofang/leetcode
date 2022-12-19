import java.util.*;

/**
 * Leetcode1971题，寻找图中是否存在路径
 * 关键字：广度优先搜索、深度优先搜索、并查集、图
 * 主要思路：
 * 1. 采用广度优先搜索，使用队列，进行广度优先搜索，从起点开始，查看是否会遍历到目标点
 * 2. 采用并查集，将连通的顶点，放到同一个集合中，每个顶点都有一个父节点，如果一个顶点没有父节点，那父节点就是自己
 */
public class LC1971 {
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        int[] visied = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            List<Integer> list = map.getOrDefault(edges[i][0],new ArrayList<>());
            list.add(edges[i][1]);
            map.put(edges[i][0],list);

            list = map.getOrDefault(edges[i][1],new ArrayList<>());
            list.add(edges[i][0]);
            map.put(edges[i][1],list);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(map.get(source));
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == destination) return true;
            if(visied[cur] == 1) continue;
            if(map.get(cur) == null) continue;
            visied[cur] = 1;
            queue.addAll(map.get(cur));
        }
        return false;
    }
    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        int[] p = new int[n];
        for(int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for(int[] edge : edges) {
            p[find(p,edge[0])] = find(p,edge[1]);
        }
        return find(p,source) == find(p,destination);
    }
    public int find(int[] p,int x) {
        return p[x] == x ? x : find(p,p[x]);
    }
}
//todo,LC1971，寻找图中是否存在路径，简单题，适合入门广度/深度优先搜索和并查集