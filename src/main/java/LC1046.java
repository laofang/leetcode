import java.util.PriorityQueue;

/**
 * Leetcode1046题，最后一块石头的重量
 * 关键字：数组、堆（优先队列）
 * 主要思路：
 * 1. 优先队列模拟，每次最大的两个对碰
 */
public class LC1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2)->{
            return e2-e1;
        });
        for(int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while(pq.size() > 1) {
            int maxWeight = pq.poll();
            int curWeight = pq.poll();
            if(maxWeight != curWeight) {
                pq.offer(maxWeight-curWeight);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
