import java.util.HashMap;

/**
 * Leetcode1090题，受标签影响的最大值
 * 关键字： 贪心、数组、哈希表、计数、排序
 * 主要思路：
 * 1. 贪心、排序和哈希表，按贪心，值最大的排在最前面
 * 2. 从最大的开始收集，分类记录每个收集的数量，如果总数量到达阈值，则返回；如果当前类达到类阈值，则跳过
 */
public class LC1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        for(int i = 1; i < values.length; i++) {
            int j = i - 1;
            int cur = values[i];
            int curL = labels[i];
            while(j >= 0 && values[j] < cur) {
                values[j+1] = values[j];
                labels[j+1] = labels[j];
                j--;
            }
            values[j+1] = cur;
            labels[j+1] = curL;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int total = 0;
        int ans = 0;
        for(int i = 0; i < values.length && total < numWanted; i++) {
            int cnt = map.getOrDefault(labels[i],0);
            if(cnt >= useLimit) continue;
            ans += values[i];
            total++;
            map.put(labels[i],cnt+1);
        }
        return ans;
    }
}
