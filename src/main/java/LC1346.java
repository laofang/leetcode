import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode1346题，检查整数及其两倍数是否存在
 * 关键字：数组、哈希表、双指针、二分查找、排序
 * 主要思路：
 * 1. 采用哈希表即可
 */
public class LC1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                if(set.contains(arr[i] / 2) || set.contains(arr[i] * 2)) return true;
            } else {
                if(set.contains(arr[i] * 2)) return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
