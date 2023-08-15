/**
 * Leetcode1952题，三除数
 * 关键字：数学
 * 主要思路：
 * 1. 按题意尝试整除即可
 */
public class LC1952 {
    public boolean isThree(int n) {
        int cur = 1;
        int cnt = 0;
        while(cur <= n) {
            if(cnt >= 4) return false;
            if(n % cur == 0) {
                cnt++;
            }
            cur++;
        }
        return cnt == 3;
    }
}
