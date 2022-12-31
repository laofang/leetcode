import java.util.Arrays;

/**
 * Leetcode2037题，使每位学生都有作为的最少移动次数
 * 关键字：数组、排序
 * 主要思路：
 * 1. 贪心，将座位和学生位置进行排序，然后求对应差的绝对值的和
 */
public class LC2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i = 0; i < seats.length;i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
