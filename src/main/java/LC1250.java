/**
 * Leetcode1250题，检查好数组
 * 关键字：数组、数学、数论
 * 主要思路：
 * 1. 这题涉及数论，不看题解，做不出来
 * 2. 裴蜀定理，d = gcd(a,b), 就一定存在整数x,y使 ax + by = d成立
 * 3. 所以此题如果存在一个子集的最大公约数是1，证明是一个好数组，子集最大公约数是1，必然整个数组的最大公约数是1
 */
public class LC1250 {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    public int gcd(int num1, int num2) {
        if(num1 % num2 == 0) return num2;
        return gcd(num2,num1 % num2);
    }
}
