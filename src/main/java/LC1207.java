/**
 * Leetcode1207题，独一无二的出现次数
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 统计每个数字出现的次数
 * 2. 再统计每个次数是否出现过
 */
public class LC1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] times = new int[2001];
        for(int i = 0; i < arr.length; i++) {
            times[arr[i]+1000]++;
        }
        int[] existTimes = new int[1001];
        for(int i = 0; i < times.length; i++) {
            if(times[i] > 0) {
                if(existTimes[times[i]] > 0) return false;
                existTimes[times[i]] = 1;
            }
        }
        return true;
    }
}
