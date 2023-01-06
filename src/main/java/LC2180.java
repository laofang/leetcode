/**
 * Leetcode2180题，统计各位数字之和为偶数的整数个数
 * 关键字：数学、模拟
 * 主要思路：
 * 1. 遍历每一个数，判断数字是否符合要求，如果符合就进行统计
 */
public class LC2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            if(isEven(i)) ++ans;
        }
        return ans;
    }
    public boolean isEven(int k) {
        int sum = 0;
        while(k != 0) {
            int t = k % 10;
            k /= 10;
            sum += t;
        }
        return sum % 2 == 0;
    }
}
