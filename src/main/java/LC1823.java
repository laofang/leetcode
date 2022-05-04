/**
 * Leetcode1823题，找出游戏的获胜者
 * 关键字：递归、队列、数组、数学、模拟
 * 主要思路：
 * f(x) = (f(n-1,k)) + k % n, n > 1
 * f(x) = 0, n = 1
 */
public class LC1823 {
    public int findTheWinner(int n, int k) {
        if(n <= 1) return 1;
        int ans = (findTheWinner(n-1,k) + k) % n;
        return ans == 0 ? n : ans;
    }
}
