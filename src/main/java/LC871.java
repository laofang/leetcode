import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode871题，最低加油次数
 * 关键字：贪心、数组、动态规划、堆
 * 主要思路：
 * 1. 每次用完当前的油量，再将路过的加油站的油量，从大到小存入优先队列
 * 2. 当前油量不足时，优先队列出队，补充油量，记录增加
 * 3. 重复以上过程，如果到达终点返回答案，如果中途需要加油时，队列为空，返回-1
 */
public class LC871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int cur = 0;
        int idx = 0;
        int ans = 0;
        int remain = startFuel;
        while(cur < target) {
            if(remain == 0) {
                if(!queue.isEmpty()) {
                    remain += queue.poll();
                    ans++;
                } else {
                    return -1;
                }
            }
            cur += remain;
            remain = 0;
            while(idx < stations.length && stations[idx][0] <= cur) queue.offer(stations[idx++][1]);
        }
        return ans;
    }
}
