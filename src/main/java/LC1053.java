/**
 * Leetcode1053题，交换一次的先前排列
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 先从后向前，找到第一个逆序位置，在这个逆序位置向后找到，小于逆序位置的值且最大的，进行交换
 */
public class LC1053 {
    public int[] prevPermOpt1(int[] arr) {
        int i = arr.length - 1;
        for(; i > 0; i--) {
            if(arr[i-1] > arr[i]) break;
        }
        if(i == 0) return arr;
        int j = i;
        int value = Integer.MIN_VALUE;
        int k = -1;
        for(; j < arr.length; j++) {
            if(arr[j] < arr[i-1] && arr[j] > value) {
                k = j;
                value = arr[j];
            }
        }
        int temp = arr[i-1];
        arr[i-1] = arr[k];
        arr[k] = temp;
        return arr;
    }
}
