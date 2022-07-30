import java.util.*;

/**
 * Leetcode349题，两个数组的交集
 * 关键字：数组、哈希表、双指针、二分查找、排序
 * 主要思路：
 * 1. 第一个数组中的元素，存储到map中
 * 2. 第二个数组的元素，查找map中是否存在，如果存在，记录到答案数组，map对应元素记录不存在
 */
public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],true);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.get(nums2[i]) != null && map.get(nums2[i])) {
                list.add(nums2[i]);
                map.put(nums2[i],false);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            ans[i++] = iterator.next();
        }
        return ans;
    }
}
