import java.util.Arrays;

/**
 * Leetcode1502题，判断能否形成等差数列
 * 关键字：数组、排序
 * 主要思路：
 * 1. 先排序，再求相邻数的差值，如果arr[i+1] - arr[i] != arr[i] - arr[i-1]不等则不能构成等差序列
 */
public class LC1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int val = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] - arr[i-1] != arr[i+1] - arr[i]) return false;
        }
        return true;
    }
}
