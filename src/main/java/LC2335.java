import java.util.Arrays;

/**
 * Leetcode2335题，装满杯子需要的最短总时长
 * 关键字：贪心、数组、排序、堆
 * 主要思路：
 * 1. 挑选两个最大值（且不为0）同时减少，结果加1，重复这个过程，直到最大值为0
 */
public class LC2335 {
    public int fillCups(int[] amount) {
        int ans = 0;
        while(true) {
            Arrays.sort(amount);
            if(amount[2] == 0) break;
            amount[2]--;
            if(amount[1] > 0) amount[1]--;
            ans++;
        }
        return ans;
    }
}
