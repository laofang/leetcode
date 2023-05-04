/**
 * Leetcode2432题，处理用时最长的那个任务的员工
 * 关键字：数组
 * 主要思路：
 * 1. 注意一下，在用时相同且最大时，选择id最小的
 */
public class LC2432 {
    public int hardestWorker(int n, int[][] logs) {
        int maxVal = 0;
        int maxId = 0;
        int pre = 0;
        int i = 0;
        while(i < logs.length) {
            int time = logs[i][1] - pre;
            if(time > maxVal) {
                maxVal = time;
                maxId = logs[i][0];
            } else if(time == maxVal) {
                maxId = Math.min(maxId,logs[i][0]);
            }
            pre = logs[i++][1];
        }
        return maxId;
    }
}
