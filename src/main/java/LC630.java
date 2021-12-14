import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode630题，课程表III
 * 关键字：数组、优先队列、贪心、排序、背包问题
 * 主要思路：
 * 已知条件：
 * (t1,d1)  (t2,d2)
 * t1 < t2
 * d1 < d2
 * 按d正序尝试学习课程，两个课程都学习的条件
 * 1:
 * t1 < d1
 * t1 + t2 < d2
 * 按d倒叙尝试学习课程，两个课程都学习的条件
 * 2:
 * t2 < d2
 * t1 + t2 < d1
 * 倒序都能够加入，那正序也能加入
 * 但
 * 正序都能狗加入，倒叙不一定能加入
 *
 * 由上可知，应该按d正序排列，尝试进行加入
 *
 * 正序遍历过程中，能学就学，如果不能学，分情况讨论：
 *
 * 1. 与已选择的课程用时相对比，如果当前用时更少，则淘汰当前选择用时最多的，加入当前用时最少的这个课程
 * 2. 如果当前用时不少于已选当中最大的，则直接跳过
 */
public class LC630 {
    public int scheduleCourse(int[][] courses) {
        //按截至日期正序排序
        Arrays.sort(courses,(e1, e2)->e1[1] - e2[1]);
        //优先队列，用时最多的课程排在前面
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2)->e2[0] - e1[0]);
        //花费天数
        int spendDay = 0;
        //正序遍历每一个课程
        for (int i = 0; i < courses.length; i++) {
            //能加就加
            if(spendDay + courses[i][0] <= courses[i][1]) {
                spendDay += courses[i][0];
                queue.offer(courses[i]);
            } else if(!queue.isEmpty()) {
                //不能加，分情况讨论
                //如果比已选的用时最多的，用时更少，那就选择当前用时更少的（在满足截止日期且可选数目相同的情况下，花费时间越少的课程，价值越高）
                if(courses[i][0] < queue.peek()[0]) {
                    spendDay -= queue.poll()[0];
                    spendDay += courses[i][0];
                    queue.offer(courses[i]);
                }
            }
        }
        return queue.size();

    }
}
