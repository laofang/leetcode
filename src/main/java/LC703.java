import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode703题，数组流中的第K大元素
 * 关键字：树、设计、二叉搜索树、二叉树、数据流、堆（优先队列）
 * 主要思路：
 * 1. 创建一个大小为k的优先队列，最小的值在栈顶，放入元素，直到队列大小为k
 * 2. 如果队列大小已经为k，只有添加的元素大于队头元素，队头出队，加入新元素，再返回队头；如果添加的元素不大于队头，直接返回队头
 */
public class LC703 {
    PriorityQueue<Integer> queue;
    int k = 0;
    public LC703(int k, int[] nums) {
        queue = new PriorityQueue<>();
        Arrays.sort(nums);
        this.k = k;
        for(int i = nums.length - 1; i >= nums.length - k && i >= 0; i--) {
            queue.offer(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size() == k) {
            int v = queue.peek();
            if(val > v) {
                queue.poll();
                queue.offer(val);
            }
        } else {
            queue.offer(val);
        }
        return queue.peek();
    }
}
