/**
 * Leetcode1122题，数组的相对排序
 * 关键字：数组、哈希表、计数排序、排序
 * 主要思路：
 * 1. 先对arr1中的每个元素进行计数
 * 2. 按arr2中的顺序，对arr1中的元素进行排序，最后再把只在arr1中的元素按顺序填入答案
 */
public class LC1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for(int i = 0; i < arr1.length; i++) {
            map[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(map[arr2[i]] > 0) {
                ans[index++] = arr2[i];
                map[arr2[i]]--;
            }
        }
        for(int i = 0; i < map.length; i++) {
            while(map[i] > 0) {
                ans[index++] = i;
                map[i]--;
            }
        }
        return ans;
    }
}
