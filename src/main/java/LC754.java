/**
 * Leetcode754题，到达终点数字
 * 关键字：数字、二分查找
 * 主要思路：
 * 1. 这道题写起来容易，但思路不是太容易想到
 * 2. 首先累计i的值，直到sum >= target
 *      1. 如果此时d = sum - target , d % 2 == 0, 这个时候只要把(d / 2)这个数字改为负数
 *      2. 如果此时d = sum - target , d % 2 == 1, 这个时候继续累加，直到d % 2 == 0为止
 */
public class LC754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 1;
        int sum = 0;
        while(true) {
            sum += i;
            if(sum >= target) {
                if((sum - target) % 2 == 0) return i;
            }
            ++i;
        }
    }
}
