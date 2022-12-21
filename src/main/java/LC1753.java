/**
 * Leetcode1753题，移除石子的最大得分
 * 关键字：贪心、数学、堆
 * 主要思路：
 * 1. 贪心+递归，每次都减少较大的两堆石子，直到有两堆石子为空
 * 2. 另一种是找数学规律：
 *  1. 如果 a + b <= c，最大得分就是 a + b；
 *  2. 如果c最大，a + b >= c, 设 a + b - c = d, a = c - b + d, 所以 a >= d 同理， b >= d， 答案就是 c + d/2,也就是（a+b+c)/2;
 */
public class LC1753 {
    public int maximumScore(int a, int b, int c) {
        if(a + b == 0 || b + c == 0 || a + c == 0) return 0;
        int res;
        if(a <= b && a <= c) {
            res = maximumScore(a,b-1,c-1) + 1;
        } else if(b <= a && b <= c) {
            res = maximumScore(a-1, b , c-1) + 1;
        } else {
            res = maximumScore(a-1,b-1,c) + 1;
        }
        return res;
    }
}
