/**
 * Leetcode 面试题 05.02 二进制数转换字符串
 * 关键字：位运算、数学、字符串
 * 主要思路：
 * 1. 要理解小数部分的二进制转化，乘2取整
 */
public class LCInterview0502 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while(sb.length() <= 32 && num != 0) {
            num *= 2;
            int val = (int) num;
            sb.append(val);
            num -= val;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
