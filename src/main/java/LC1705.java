import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode1705题，吃苹果的最大数目
 * 关键字：数组、贪心、优先队列
 * 主要思路：
 * 1. 将每天新增的苹果，按过期日排列，放入优先队列
 * 2. 每天吃苹果先吃过期日距当前时间最近的
 * 3. 如果当前要吃的苹果已经吃完，或者已经过期则出队
 */
public class LC1705 {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        //按过期日进行排序的优先队列，优先吃即将过期的
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        for (int i = 0; !queue.isEmpty() || i < apples.length; i++) {
            //每天生成的苹果入队，前n天有苹果入队，之后每天只吃苹果
            if(i < apples.length) {
                //int[0]过期日期，int[1]苹果数量
                queue.offer(new int[]{i + days[i],apples[i]});
            }
            //吃苹果
            while(!queue.isEmpty()) {
                int[] temp = queue.peek();
                //烂了或者苹果已吃完,出队
                if(i >= temp[0] || temp[1] <= 0) {
                    queue.poll();
                    continue;
                }
                //苹果数量-1
                --temp[1];
                //已吃苹果数量+1
                ++ans;
                break;
            }
        }
        return ans;
    }
}
