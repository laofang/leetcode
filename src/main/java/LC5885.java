import java.util.Arrays;

/**
 * Leetcode5885,竞赛题，使每位学生都有座位的最小移动次数
 * 主要思路：
 * 关键词：排序，贪心
 * 1. 当时只是直觉觉得将两数组排序，再取对应学生和座位的差的绝对值的和即可
 * 2. 并没有想清楚为何这就是答案
 */
public class LC5885 {
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i = 0; i < seats.length; i++){
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
