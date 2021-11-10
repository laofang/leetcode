/**
 * Leetcode495题，提莫攻击
 * 关键字：数组
 * 主要思路：
 * 1. 看之前的中毒区间是否相交
 * 2. 如果相邻的两个攻击时间差，小于中毒时长那么增加中毒时间就是timeSeries[i] - timeSeries[i-1]
 * 3. 否则增加的时间就是一次攻击的时间中毒时间
 */
public class LC495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration;
        for( int i = 1; i < timeSeries.length; i++) {
            ans += Math.min(duration,timeSeries[i] - timeSeries[i-1]);
        }
        return ans;
    }
}
