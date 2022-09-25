/**
 * Leetcode788题，旋转数字
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 遍历[1,n]，如果一个数字不存在3,4,7且存在2569就是一个好数
 * 2. 对每一位数字进行上面的判断
 */
public class LC788 {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(isRotateDigit(i)) ++ans;
        }
        return ans;
    }
    public boolean isRotateDigit(int num) {
        boolean is2569 = false;
        while(num != 0) {
            int t = num % 10;
            num /= 10;
            if(t == 3 || t == 4 || t == 7) return false;
            if(t == 2 || t == 5 || t == 6 || t == 9) is2569 = true;
        }
        return is2569;
    }
}
