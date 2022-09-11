import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, righti] 。
 *
 * 你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。
 *
 * 请你返回 最少 需要划分成多少个组。
 *
 * 如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。
 * Leetcode6178题，将区间分为最少组数
 * 关键字：贪心、排序、堆
 * 主要思路：
 * 1. 使用小根堆，存储右边界
 * 2. 如果新的区间的左边界，在最小边界的右侧，说明可以合并一组，将堆顶出堆，新区间的右边界入堆，否则新生成一组
 */
public class LC6178 {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(e -> e));
        Arrays.sort(intervals,(e1, e2)-> {
            if(e1[0] != e2[0]) return e1[0] - e2[0];
            return e1[1] - e2[1];
        });
        for(int i = 0;i < intervals.length; i++) {
            if(q.isEmpty()) {
                q.offer(intervals[i][1]);
            } else {
                if(intervals[i][0] > q.peek()) {
                    q.poll();
                }
                q.offer(intervals[i][1]);
            }
        }
        return q.size();
    }
}

//todo，Leetcode6178题，将区间分为最少组数，需要复习的题目
