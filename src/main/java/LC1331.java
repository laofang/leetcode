import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1331题，数组序号转换
 * 关键字：数组、哈希表、排序
 * 主要思路：
 * 1. 先排序，再哈希记录顺序
 * 2. 再按原顺序，找到每个元素对应哈希表中记录的位置
 */
public class LC1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrCopy);
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 1;

        for (int i = 0; i < arrCopy.length; i++) {
            if(i == 0) {
                map.put(arrCopy[i],cnt);
                continue;
            }
            if(arrCopy[i] != arrCopy[i-1]) {
                cnt++;
                map.put(arrCopy[i],cnt);
            }
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
