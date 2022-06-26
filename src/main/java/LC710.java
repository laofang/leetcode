import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Leetcode710题，黑名单中的随机数
 * 关键字：哈希表、数学、二分查找、排序、随机化
 * 主要思路：
 * 1. 主要使用hash的方法来做，设总范围为[0,n-1],黑名单长度m，将在[0,n-m-1]中的黑名单映射到[n-m,n-1]中
 * 2. 第一步，遍历黑名单，如果黑名单的值 >= n - m，那就记录在hashmap中
 * 3. 第二步，再次遍历黑名单，如果黑名单的值 < n，那就建立映射
 * 总结：将前部分中黑名单的值与后部分非黑名单的值建立映射，然后随机范围在[0,n-m-1]
 */
public class LC710 {
    Map<Integer,Integer> laterMap = new HashMap<>();
    Map<Integer,Integer> map = new HashMap<>();
    Random random = new Random();
    int range = 0;
    public LC710(int n, int[] blacklist) {
        int m = blacklist.length;
        int k = n - m;
        range = k;
        for (int i = 0; i < blacklist.length; i++) {
            if(blacklist[i] >= k) {
                laterMap.put(blacklist[i],blacklist[i]);
            }
        }
        for (int i = 0; i < blacklist.length; i++) {
            if(blacklist[i] < range) {
                while(k < n && laterMap.get(k) != null) k++;
                if(k < n) {
                    map.put(blacklist[i],k);
                    k++;
                }
            }
        }

    }

    public int pick() {
        int ans = random.nextInt(range);
        return map.getOrDefault(ans,ans);
    }
}
