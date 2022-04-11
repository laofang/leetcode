/**
 * Leetcode357题，统计各位数字都不同的数字个数
 * 关键字：
 * 主要思路：
 * 1. 当n>1时，n位数字具有 9 * 9 * 8 * 7 * 6 ……个不同的数字(第一位除零外的9种选择，之后依次类推）。
 * 2. 上面算的是n位数字，不存在重复数字的个数，还要加上 0~10^n中不重复的数字的个数。
 * 3. 其实也就是一个递归，算n位的不重复个数+(n-1)位的不重复的个数+(n-2)……
 */
public class LC357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 10;
        }
        int sum = 9;
        int k = 9;
        for(int i = 2; i <= n; i++) {
            sum = sum * k--;
        }
        return sum + countNumbersWithUniqueDigits(n-1);
    }
}
