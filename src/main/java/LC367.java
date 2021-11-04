/**
 * Leetcode367题，有效的完全平方数
 * 关键字：数学
 * 主要思路:
 * 1. 二分查找即可
 * 2. 解析里说1+3+5+……+2*n-1即是完全平方数，如果一个数，从1，3，5这样依次去减，如果能减到0说明是完全平方数
 * 注意事项：
 * 乘法可能有溢出的情况，需要注意
 */
public class LC367 {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;

        while(left <= right) {
            long half = (left + right) / 2;
            long target = half * half;
            if(target == num) {
                return true;
            } else if(target < num) {
                left = half + 1;
            } else {
                right = half - 1;
            }
        }
        return false;
    }
}
