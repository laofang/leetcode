import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode题，剑指offer II 041题，滑动窗口的平均值
 * 关键字：设计、队列、数组、数据流
 * 主要思路：
 * 1. 用队列做滑动窗口，同时维持窗口内的元素和
 * 2. 窗口没满就进元素，累计元素和
 * 3. 如果窗口已满，队头出队，同时元素和减队头；新元素入队，元素和加新元素
 */
public class LCofferII41 {
    int size;
    Queue<Integer> queue;
    int sum = 0;
    public LCofferII41(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if(queue.size() == size) {
            int head = queue.poll();
            sum -= head;
        }
        queue.offer(val);
        sum += val;
        return (double)sum / queue.size();
    }
}
