/**
 * Leetcode507题，完美数
 * 关键字：数组、数学
 * 主要思路：
 * 1. 很简单的一道题，直接遍历就可以了
 * ps:2021年的最后一题，2022你好，2021再见
 */
public class LC507 {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int n = num / 2;
        int ans = 0;
        for(int i = 2 ; i < n;i++) {
            if(num % i == 0) {
                if(i == num / i) {
                    ans += i;
                } else if(i < num / i) {
                    ans += i + num / i;
                } else {
                    break;
                }
            }
        }
        return ++ans == num;
    }
}
