/**
 * Leetcode2028题，找出缺失的观测数据
 * 关键字：数组数学模拟
 * 主要思路：
 * 1. sum(n) = mean * (m + n) - sum(m) 求出n数组的和
 * 2. 再将sum(n)分配到n个数组上即可，但要注意是否符合要求
 */
public class LC2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //求m数组的和
        int sumM = 0;
        for (int i = 0; i < rolls.length; i++) {
            sumM += rolls[i];
        }
        //sum(n) = mean * (m + n) - sum(m) 求出n数组的和
        int sumN = mean * (rolls.length + n) - sumM;

        //n组中，每个元素的基本大小，以及余数
        int value = sumN / n;
        int yu = sumN % n;

        //如果基本大小小于0，或者大于6，或者等于6时余数大于0 都是不可能的
        if(value <= 0 || value > 6 || value == 6 && yu > 0) return new int[0];
        int[] ans = new int[n];

        //向数组赋值，并将余数进行分配
        for(int i = 0; i < n; i++) {
            ans[i] = value;
            if(i < yu) ans[i] = value + 1;
        }
        return ans;
    }
}
