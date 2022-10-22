import java.util.Arrays;

/**
 * Leetcode1235题，规划兼职工作
 * 关键字：数组、二分查找、动态规划、排序
 * 主要思路：
 * 1. 先将job按结束时间进行排序
 * 2. 定义转移方程， f(i)是前i个工作的最大报酬
 * 3. 遍历到job[i]的时候，有两种选择
 *      1. 不选择job[i]，f(i) = f(i-1)
 *      2. 如果选择job[i]，就要在[0,i)之间选择一个j，jobs[j]是结束时间小于等于jobs[i]的开始时间的最大值，f(i + 1) = f(j) + f(i)
 */
public class LC1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length + 1;
        int[][] jobs = new int[n-1][3];
        for (int i = 0; i < profit.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs,(e1, e2)-> e1[1] - e2[1]);
        int[] f = new int[n];
        for(int i = 0; i < jobs.length; i++) {
            int j = search(jobs,jobs[i][0],i-1);
            f[i + 1] = Math.max(f[i],f[j+1] + jobs[i][2]);
        }
        return f[n-1];

    }
    public int search(int[][] jobs, int st, int right) {
        int left = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(jobs[mid][1] <= st) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left-1;
    }
}
//todo,(已完成，但具有学习价值，困难，序列DP和二分法），Leetcode1235，规划兼职工作