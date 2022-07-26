/**
 * Leetcode374题，猜数字大小
 * 关键字：二分查找、交互
 * 主要思路：
 * 1. 二分查找
 */
public class LC374 {
    public int guessNumber(int n) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        while(left <= right) {
            long half = (left + right) / 2;
            int flag = guess((int)half);
            if(flag == 0) {
                return (int)half;
            } else if(flag == -1) {
                right = half;
            } else {
                left = half + 1;
            }
        }
        return -1;
    }
    public int guess(int num) {
        return 1;
    }
}
