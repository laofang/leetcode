import java.util.Arrays;

/**
 * Leetcode1619题，删除某些元素后的数组均值
 * 关键字：数组、排序
 * 主要思路：
 * 1. 对数组进行排序，k = arr.length / 20
 * 2. 求从[k,arr.length-2]的和，再除以元素数量
 */
public class LC1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int k = arr.length / 20;
        int sum = 0;
        for(int i = k; i < arr.length - k;i++) sum += arr[i];
        return sum / ((double) arr.length - 2 * k);
    }
}
