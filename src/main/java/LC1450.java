/**
 * Leetcode1450题，在既定时间做作业的学生人数
 * 关键字：数组
 * 主要思路：
 * 1. 遍历，找到既定范围做作业的人，进行累加
 */
public class LC1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for(int i = 0; i < startTime.length; i++) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
