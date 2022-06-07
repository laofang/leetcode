/**
 * Leetcode875题，爱吃香蕉的珂珂
 * 关键字：数组、二分查找
 * 主要思路：
 * 1. 通过二分查找，找到一个速度k，满足速度为k时，恰好h小时吃完香蕉，且k足够小
 * 小技巧：
 * 1. x / y 向上取整，可以(x + y - 1) / y
 */
public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = (int)1e9;
        while(l <= r) {
            int k = (l + r) / 2;
            int time = needTime(k,piles);
            if(time <= h) {
                r = k - 1;
            } else if(time > h) {
                l = k + 1;
            }
        }
        return l;
    }
    public int needTime(int k, int[] piles) {
        int time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += (piles[i] + k - 1) / k;
        }
        return time;
    }
}
