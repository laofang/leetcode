/**
 * Leetcode504题，七进制数
 * 关键字：数学、进制
 * 主要思路：
 * 1. 按进制算规则算就可以
 */
public class LC504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder ans = new StringBuilder();
        int num1 = num < 0 ? -num : num;
        while(num1 != 0) {
            int a = num1 % 7;
            num1 = num1 / 7;
            ans.append(a);
        }
        if(num < 0) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }
}
