import java.util.*;

/**
 * Leetcode622题，设计循环队列
 * 关键字：数组、哈希表、双指针、二分查找、排序
 * 主要思路：
 * 1. 使用哈希表，记录其中一个数组的每个数字出现的次数；
 * 2. 使用另一个数组，从哈希表，获取每个数字的数量，如果数量大于0，记录数字，同时减少数量
 */
public class LC622 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int count = map.getOrDefault(nums1[i],0);
            map.put(nums1[i],++count);
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i],0);
            if(count > 0) {
                map.put(nums2[i],--count);
                ans.add(nums2[i]);

            }
        }
        int[] result = new int[ans.size()];
        Iterator<Integer> iterator = ans.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        return result;
    }
}
