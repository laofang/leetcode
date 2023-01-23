/**
 * Leetcode2303题，计算应缴税款总额
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 按题意进行模拟
 */
public class LC2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for(int i = 0; i< brackets.length; i++) {
            double curVal = 0;
            if(i == 0) {
                curVal = Math.min(brackets[i][0],income);
            } else {
                curVal = income >= brackets[i][0] ? brackets[i][0] - brackets[i-1][0] : income - brackets[i-1][0];
            }
            ans += curVal * brackets[i][1] / 100;
            if(brackets[i][0] >= income) break;
        }
        return ans;
    }
}
