/**
 * Leetcode67题，二进制求和
 * 关键字：二进制、数学、模拟
 * 主要思路：
 * 1. 和Leetcoe2，"两数相加"的思路基本一样，第二题模拟的是十进制相加，这道题是二进制相加
 * 2. 每次相加可能存在a的一位，b的一位，（同一进制位）和carry，这三个变量可能都存在，当都不存在时，就结束运算
 */
public class LC67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        //最终答案
        StringBuilder sb = new StringBuilder();
        //从后往前，按位相加
        while(i >= 0 || j >= 0 || carry > 0) {
            int x = 0;
            int y = 0;
            if(i >= 0) {
                //因为是数字字符，记得-‘0’
                x = Integer.valueOf(a.charAt(i)-'0');
                i--;
            }
            if(j >= 0){
                y = Integer.valueOf(b.charAt(j)-'0');
                j--;
            }
            int sum = x + y +carry;
            carry = sum / 2;
            sb.append(sum%2);
        }
        //最后反转就是答案，因为加的时候是从后往前进入的
        return sb.reverse().toString();
    }
}
