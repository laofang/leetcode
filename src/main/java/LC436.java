import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode436题，寻找右区间
 * 关键字：数组、二分查找、排序
 * 主要思路：
 * 1. 按start进行排序，排序前记录索引
 * 2. 然后遍历每一个区间，在排序数组上，查找当前区间[x,y]的最小右区间，也就是end >= y的最小存在所在的区间
 */
public class LC436 {
    public int[] findRightInterval(int[][] intervals) {
        Map<int[],Integer> map = new HashMap<>(intervals.length / 4);
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i],i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        int[] ans = new int[intervals.length];
        Arrays.fill(ans,-1);
        for(int i = 0; i < intervals.length; i++) {
            int l = i;
            int r = intervals.length - 1;
            while(l <= r) {
                int half = (l + r) / 2;
                if(intervals[i][1] > intervals[half][0]) {
                    l = half + 1;
                } else if(intervals[i][1] <= intervals[half][0]) {
                    r = half - 1;
                }
            }
            if(l == intervals.length) {
                ans[map.get(intervals[i])] = -1;
            }else {
                ans[map.get(intervals[i])] = map.get(intervals[l]);
            }

        }
        return ans;
    }
}
