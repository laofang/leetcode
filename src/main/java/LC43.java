/**
 * Leetcode43题，字符串相乘
 * 关键字：数字、字符串、模拟
 * 主要思路：
 * 1. 主要就是乘法的规则，相乘相加
 * 2. 大学的时候用C语言做过这道题，但这次花了好长时间
 */
public class LC43 {
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length()];
        int[] ans = new int[num1.length() + num2.length()];
        //如果有个0，则乘积为0
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        for(int i = num1.length() - 1; i >= 0; i--) {
            nums[num1.length() - i - 1] = (int)num1.charAt(i) - '0';
        }
        for(int i = num2.length() - 1; i >= 0; i--) {
            int n2 = (int)num2.charAt(i) - '0';
            //n2的当前位置
            int n2i = num2.length() - i - 1;
            int carry = 0;
            for (int j = 0; j < nums.length; j++) {
                //两数的乘积
                int temp = nums[j] * n2;
                //根据两数位置，可以得知乘积应在的位置
                ans[n2i + j ] += temp % 10;
                //进位
                carry = ans[n2i + j ] / 10 + temp / 10;
                //当前可能大于10，所以需要再模10
                ans[n2i + j ] %= 10;
                int k = 1;
                while(carry > 0 && n2i+j+k < ans.length) {
                    ans[n2i + j + k] += carry;
                    carry = ans[n2i + j + k] / 10;
                    ans[n2i + j + k] %= 10;
                    k++;
                }
            }
        }
        int i = 0;
        for(i = ans.length - 1; i >= 0; i--) {
            if(ans[i] != 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = i; k >= 0; k--) {
            sb.append(ans[k]);
        }
        return sb.toString();
    }
    //TODO LC43.字符串相乘，找一下为什么效率不够高
}
