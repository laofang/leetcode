import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。第 i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。你 最多 可以参加 两个时间不重叠 活动，使得它们的价值之和 最大 。
 *
 * 请你返回价值之和的 最大值 。
 *
 * 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。更具体的，如果你参加一个活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。
 *
 * 主要思路：
 * 1.
 */
public class LC2054 {
    public int maxTwoEvents(int[][] events) {
        //按开始时间排序
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        int n = events.length - 1;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int ans = 0;
        for(int i = n ; i >=0 ;i--) {
            int[] cur = events[i];
            //已访问过的可匹配的最大价值event
            Integer index = tm.higherKey(cur[1]);
            if(index != null) {
                ans = Math.max(ans,cur[2] + tm.get(index));
            }

            //已访问过的记录中的后一个任务
            index = tm.ceilingKey(cur[0]);
            if(index == null || cur[2] > tm.get(index)) {
                tm.put(cur[0],cur[2]);
            }

        }
        int max = tm.get(tm.firstKey());
        ans = Math.max(max,ans);
        return ans;
    }
}
