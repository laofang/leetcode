/**
 * Leetcode1299题，将每个元素替换为右侧最大元素
 * 关键字：数组
 * 主要思路：
 * 1. 从后往前，保存当前最大值，逐一赋值
 */
public class LC1299 {
    public int[] replaceElements(int[] arr) {
        int max = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(i == arr.length - 1) {
                max = arr[i];
                arr[i] = -1;
            } else {
                int preMax = max;
                max = Math.max(arr[i],max);
                arr[i] = preMax;
            }

        }
        return arr;
    }
}
