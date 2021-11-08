import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode5921题，最大化一张图中的路径价值
 * 给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，其中 values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。
 *
 * 合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。
 *
 * 请你返回一条合法路径的 最大 价值。
 *
 * 注意：每个节点 至多 有 四条 边与之相连。
 *
 * 关键字：DFS、图
 * 主要思路：
 * 1. 深度优先搜索
 * 2. 先建图的邻接表
 * 3. 然后深度遍历，需要注意的是，遍历到某一个元素时，加上这个元素的价值后，将当前元素价值置0，直到这个节点深度遍历结束后，还原
 */
public class LC5921 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> m = new HashMap<>();
        //构造图的邻接表
        for(int i = 0; i < edges.length; i++) {

            List<int[]> l1 = m.getOrDefault(edges[i][0],new ArrayList<>());
            int[] temp = new int[]{edges[i][1],edges[i][2]};
            l1.add(temp);
            m.put(edges[i][0],l1);

            List<int[]> l2 = m.getOrDefault(edges[i][1],new ArrayList<>());
            int[] temp1 = new int[]{edges[i][0],edges[i][2]};
            l2.add(temp1);
            m.put(edges[i][1],l2);

        }
        int[] ans = new int[1];
        ans[0] = values[0];
        dfs(ans,m,0,0,maxTime,0,values);
        return ans[0];

    }
    public void dfs(int[] ans, Map<Integer,List<int[] >> m, int start, int time, int limit, int value, int[] values) {
        //每个节点的相邻节点列表
        List<int[]> l = m.get(start);
        //当前节点价值
        int lastValue = values[start];
        //加上再置0
        value += lastValue;
        values[start] = 0;
        //当前节点是0节点，比较一下当前价值和当前答案
        if(start == 0) {
            ans[0] = Math.max(ans[0],value);
        }
        //当前节点存在相邻节点
        if(l != null) {
            for(int[] node : l) {
                //如果去下个节点超时，就继续循环，看相邻的另一个节点
                if(time + node[1] > limit) {
                    continue;
                }
                //已用时加上到下个节点的用时
                int eTime = node[1];
                time += eTime;
                // System.out.println(start + " " + node[0] + " " + node[1] + " " +value);
                //去下个节点继续深度遍历
                dfs(ans,m,node[0],time,limit,value,values);
                //用时还原
                time -= eTime;
            }
        }
        //当前节点价值还原
        values[start] = lastValue;
    }
}
