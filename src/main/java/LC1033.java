/**
 * Leetcode1033题，移动石子直到连续
 * 关键字：脑筋急转弯、数学
 * 主要思路：
 * 1. x<y<z,最大的值等于y - x - 1 + z - y - 1
 * 2. 最小的回合数分情况，x == y - 1 == z - 2 ，连续的情况，最小值就为0
 * 3. x >= y - 2 或 z <= y + 2,这种相邻，最小值为1
 * 4. 除了以上情况，最小值都为2
 */
public class LC1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(a > c) {
            int temp = a;
            a = c;
            c = b;
            b = temp;
        }
        if(b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        ans[1] = c - b - 1 + b - a - 1;
        if(a == b - 1 && c == b + 1) ans[0] = 0;
        else if(a >= b - 2 || c <= b + 2) ans[0] = 1;
        else ans[0] = 2;
        return ans;
    }
}
