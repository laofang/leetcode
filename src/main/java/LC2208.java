import java.util.PriorityQueue;

/**
 * Leetcode2208题，将数组和减半的最少操作次数
 * 关键字：贪心、数组、堆
 * 主要思路：
 * 1. 优先队列，采用贪心算法，每次选最大的值折半，再放回队列，直到和小于等于初始和的一半
 */
public class LC2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>((e1, e2)->{
            double val = e2 - e1;
            if(val > 0) return 1;
            else if(val < 0) return -1;
            else return 0;

        });
        double sum = 0f;
        for(int i = 0; i < nums.length; i++) {
            queue.offer((double)nums[i]);
            sum += (double)nums[i];
        }
        double half = sum / 2;
        int cnt = 0;
        while(sum > half) {
            cnt++;
            double cur = queue.poll();
            cur /= 2;
            sum -= cur;
            queue.offer(cur);
        }
        return cnt;
    }
}
