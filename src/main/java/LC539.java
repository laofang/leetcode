import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode539题，最小时间差
 * 关键字：数组、排序、字符串
 * 主要思路：
 * 1. 把时间字符串转化成分钟
 * 2. 按大小排序，第一个要+60*24加到末尾
 * 3. 相邻的的做差，最小的差就是最小时间差
 */
class LC539 {
    public int findMinDifference(List<String> timePoints) {

        Queue<Integer> q = new PriorityQueue<>((e1, e2)->e1-e2);
        for(int i = 0; i < timePoints.size(); i++) {
            String[] times = timePoints.get(i).split(":");
            int minutes = Integer.valueOf(times[0]) * 60;
            minutes += Integer.valueOf(times[1]);
            q.offer(minutes);
        }

        int ans = 24 * 60 + 1;
        q.offer(q.peek() + 24 * 60);
        int pre = q.poll();

        while(!q.isEmpty()) {
            ans = Math.min(ans,q.peek() - pre);
            pre = q.poll();
        }
        return ans;
    }
}
