/**
 * Leetcode769题，最多能完成排序的块
 * 关键字：栈、数组、排序、贪心、单调栈
 * 主要思路：
 * 1. 每块的最大值，要与这块的最大索引相等，因为这个最大值，要放到这个索引上
 * 2. 根据上面的条件，进行遍历，如果当前索引等于遍历过的最大值，那就可以分为一块
 */
public class LC769 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            if(max == i) ++ans;
        }
        return ans;
    }
}
