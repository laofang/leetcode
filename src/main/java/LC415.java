/**
 * Leetcode415题，字符串相加
 * 关键字：数学、字符串、模拟
 * 主要思路：
 * 1. 模拟加法规律进行相加
 */
public class LC415 {
    public String addStrings(String num1, String num2) {
        int ans = 0;
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int i = n1.length - 1;
        int j = n2.length - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int a = i >= 0 && n1[i] - '0' > 0 ? n1[i] - '0' : 0;
            int b = j >= 0 && n2[j] - '0' > 0 ? n2[j] - '0' : 0;
            i--;
            j--;
            int val = a + b + carry;
            if(val >= 10) {
                carry = 1;
                val -= 10;
            } else carry = 0;
            sb.append(val);
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
