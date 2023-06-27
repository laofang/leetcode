/**
 * Leetcode1287题，有序数组中出现次数超过25%的元素
 * 关键字：数组
 * 主要思路：
 * 1. 已经有序，遍历计数，如果count * 4 > arr.length,当前数字就是答案
 */
public class LC1287 {
    public int findSpecialInteger(int[] arr) {
        int cnt = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                cnt++;
                if(cnt * 4 > arr.length) return arr[i];
            } else {
                cnt = 1;
            }
        }
        return cnt * 4 > arr.length ? arr[arr.length - 1] : -1;
    }
}
