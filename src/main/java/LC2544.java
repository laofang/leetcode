/**
 * Leetcode2544题，交替数字和
 * 关键字：数学
 * 主要思路：
 * 1. 假设最低位是正数，交替相加，同时对位数计数
 * 2. 如果位数是奇数，那就返回sum，否则返回-sum
 */
public class LC2544 {
    public int alternateDigitSum(int n) {
        int cnt = 0;
        int sum = 0;
        while(n > 0) {
            int num = n % 10;
            n /= 10;
            sum = cnt % 2 == 0 ? sum + num : sum - num;
            cnt++;
        }
        return cnt % 2 == 1 ? sum : -sum;
    }
}
