/**
 * Leetcode537题，复数乘法
 * 关键字：字符串、数字、模拟
 * 主要思路：
 * 1. 模拟复数乘法的运算过程
 * 2. 十字相乘，(a+bi)*(c+di) = ac - bd + (cd+ad)*i
 */
public class LC537 {
    public String complexNumberMultiply(String num1, String num2) {

        int[] a = new int[2];
        int[] b = new int[2];

        String[] aS = num1.split("\\+");
        String[] bS = num2.split("\\+");

        a[0] = Integer.valueOf(aS[0]);
        a[1] = Integer.valueOf(aS[1].replace("i",""));
        b[0] = Integer.valueOf(bS[0]);
        b[1] = Integer.valueOf(bS[1].replace("i",""));

        return new StringBuilder().append(a[0] * b[0] - a[1] * b[1])
                .append("+")
                .append(a[0] * b[1] + a[1] * b[0])
                .append("i").toString();
    }
}
