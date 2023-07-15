/**
 * Leetcode1317题，将整数转换为两个无零整数的和
 * 关键字：数学
 * 主要思路：
 * 1. 遍历，每次两个数判断是否含0，如果不含零就是答案
 */
public class LC1317 {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1 ; i < n; i++) {
            int a = i;
            int b = n-a;
            while(a != 0) {
                if(a % 10 == 0) break;
                a /= 10;
            }
            while(b != 0) {
                if(b % 10 == 0) break;
                b /= 10;
            }
            if(a != 0 || b != 0) continue;
            return new int[]{i,n-i};
        }
        return new int[]{};
    }
}
