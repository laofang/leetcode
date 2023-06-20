/**
 * Leetcode1281他，整数的各位积和之差
 * 关键字：数字
 * 主要思路：
 * 1. 按位求积与和，然后做差即可
 */
public class LC1281 {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n != 0) {
            int cur = n % 10;
            n /= 10;
            mul *= cur;
            sum += cur;
        }
        return mul - sum;
    }
}
