/**
 * Leetcode1460题，通过翻转子数组使两个数组相等
 * 关键字：数组、哈希表、排序
 * 主要思路：
 * 1. 只要两个数组里的元素相同，其中一个通过一定的旋转，一定可以变成另一个
 * 2. 所以只要判定两个数组元素是否一样即可
 */
public class LC1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cache = new int[1001];
        for (int i = 0; i < target.length; i++) {
            cache[target[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            cache[arr[i]]--;
            if(cache[arr[i]] < 0) return false;
        }
        return true;
    }
}
