import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode1801题，积压订单中的订单总数
 * 关键字：数字、模拟、堆
 * 主要思路：
 * 1. 使用优先队列，然后模拟规则，采购订单降序排列，销售订单升序排列
 * 2. 队头元素按规则互消，最后再统计剩余的订单数量
 */
public class LC1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = 1000000007;
        PriorityQueue<Integer> buyOrders = new PriorityQueue<>((i1, i2)->orders[i2][0] - orders[i1][0]);
        PriorityQueue<Integer> sellOrders = new PriorityQueue<>(Comparator.comparingInt(i -> orders[i][0]));
        for(int i = 0; i < orders.length; i++) {
            if(orders[i][2] == 0) {
                buyOrders.offer(i);
            } else {
                sellOrders.offer(i);
            }
            while(!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
                int i1 = buyOrders.peek();
                int i2 = sellOrders.peek();
                if(orders[i1][0] < orders[i2][0]) break;
                int min = Math.min(orders[i1][1],orders[i2][1]);
                orders[i1][1] -= min;
                orders[i2][1] -= min;
                if(orders[i1][1] == 0) buyOrders.poll();
                if(orders[i2][1] == 0) sellOrders.poll();
            }
        }
        int ans = 0;
        for(int[] order : orders) {
            ans = (ans + order[1]) % MOD;
        }
        return ans;
    }
}
