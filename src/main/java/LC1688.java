/**
 * Leetcode1688题，比赛中的配对次数
 * 关键字：模拟、数学
 * 主要思路：
 * 1. 模拟就可以了
 * 2. 每次匹配是n / 3
 * 3. 下一次比赛的队伍数量是 n / 3 + n % 3
 */
public class LC1688 {
    public int numberOfMatches(int n) {
        int ans = 0;
        while(n > 1) {
            int times = n / 2;
            ans += times;
            n = times + n % 2;
        }
        return ans;
    }
}
