/**
 * Leetcode1342题，将数字变成0的操作次数
 * 关键字：位运算、数学、模拟
 * 主要思路：
 * 1. 模拟就可以了
 */
public class LC1342 {
    public int numberOfSteps(int num) {
        int ans = 0;
        while(num != 0) {
            num = (num & 1) == 0 ? num >> 1 : num - 1 ;
            ans++;
        }
        return ans;
    }
}
