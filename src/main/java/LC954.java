import java.util.*;

/**
 * Leetcode954题，二倍数对数组
 * 关键字：贪心、数组、哈希表、排序
 * 主要思路：
 * 1. Map记录每个数字出现的次数
 * 2. List记录每一个出现的数字，并按绝对值的大小正序排序
 * 3. 如果当前数字x < 2x 的次数，说明x可以被完匹配，重复这个过程
 */
public class LC954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int x : map.keySet()) {
            list.add(x);
        }
        Collections.sort(list,(e1, e2) -> {
            return Math.abs(e1) - Math.abs(e2);
        });
        for(int x : list) {
            if(map.get(x) > map.getOrDefault(2 * x,0)) {
                return false;
            }
            map.put(2 * x, map.getOrDefault(2*x,0) - map.get(x));
        }
        return true;
    }
}
