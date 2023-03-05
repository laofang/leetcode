/**
 * Leetcode1599题，经营摩天轮的最大利润
 * 关键字：数组、模拟
 * 主要思路：
 * 1. 完全模拟，有四个人就上四个人，如果不够，就从等待人中尽量补
 * 2. 遍历结束，再将等待中的人四个一组上去，每一次都进行利润的计算
 */
public class LC1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waitCnt = 0;
        int ans = 0;
        int profit = 0;
        int times = 0;
        int maxTime = 0;
        for(int cusCnt : customers) {
            if(cusCnt > 4) {
                waitCnt += cusCnt - 4;
                cusCnt = 4;
            } else if(cusCnt < 4) {
                int pos = 4 - cusCnt;
                if(waitCnt >= pos) {
                    cusCnt += pos;
                    waitCnt -= pos;
                } else {
                    cusCnt += waitCnt;
                    waitCnt = 0;
                }
            }
            profit += cusCnt * boardingCost - runningCost;
            times++;
            if(profit > ans) {
                ans = profit;
                maxTime = times;
            }
        }
        while(waitCnt > 0) {
            times++;
            if(waitCnt > 4) {
                profit += 4 * boardingCost - runningCost;
                waitCnt -= 4;
            } else {
                profit += waitCnt * boardingCost - runningCost;
                waitCnt = 0;
            }
            if(profit > ans) {
                ans = profit;
                maxTime = times;
            }
        }
        return maxTime == 0 ? -1 : maxTime;
    }
}
