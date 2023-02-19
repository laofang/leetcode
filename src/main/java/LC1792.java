import java.util.PriorityQueue;

/**
 * Leetcode1792题，最大平均通过率
 * 关键字：贪心、数组、堆
 * 主要思路：
 * 1. 使用优先队列，采用贪心来实现
 * 2. 优先将学生分配给能使通过率增长最多班级，假设某班级通过率为x / y，给他一个学生，通过率为 (x+1) / (y+1)，后与前差值就是增长量
 * 3. 按预期增长量从大到小加入优先队列，再每次出队，加入学生，再放回
 * 4. 最后计算整体通过率
 */
public class LC1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            long val1 = (long) (e2[1] + 1) * e2[1] * (e1[1] - e1[0]);
            long val2 = (long) (e1[1] + 1) * e1[1] * (e2[1] - e2[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for(int i = 0; i < classes.length; i++) {
            pq.offer(classes[i]);
        }
        int i = extraStudents;
        while (i > 0) {
            int[] temp = pq.poll();
            temp[0]++;
            temp[1]++;
            pq.offer(temp);
            i--;
        }
        double ans = 0f;
        while(!pq.isEmpty()) {
            int[] temp =pq.poll();
            ans += (double) temp[0] / temp[1];
        }
        return ans / classes.length;
    }
}
