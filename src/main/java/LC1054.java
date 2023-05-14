import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode1054题，距离相等的条形码
 * 关键字：贪心、数组、哈希表、计数、排序、堆（优先队列）
 * 主要思路：
 * 1. 采用优先队列和贪心
 * 2. 每次把最大的队列里最大的两个进行交错排序，直到全部用完
 */
public class LC1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int k : barcodes) {
            int cnt = map.getOrDefault(k,0);
            cnt++;
            map.put(k,cnt);
        }
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2)->{
            if(e2[1] != e1[1] ) return e2[1] - e1[1];
            return e2[0] - e1[0];
        });
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getKey(),e.getValue()});
            i++;
        }
        int[] ans = new int[barcodes.length];
        i = 0;
        while(i < ans.length && !pq.isEmpty()) {
            int[] top1 = pq.poll();
            if(pq.isEmpty()) {
                ans[i] = top1[0];
                break;
            } else {
                int[] top2 = pq.poll();
                ans[i] = top1[0];
                ans[i+1] = top2[0];
                --top1[1];
                --top2[1];
                if(top1[1] != 0) {
                    pq.offer(top1);
                }
                if(top2[1] != 0) {
                    pq.offer(top2);
                }
                i = i + 2;
            }
        }
        return ans;
    }
}
