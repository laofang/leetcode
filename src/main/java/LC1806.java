import java.util.Arrays;

/**
 * Leetcode1806题，还原排列的最少操作步数
 * 关键字：数组、数学、模拟
 * 主要思路：
 * 1. 按题意进行模拟就可以，需要注意一下数组的copy
 */
public class LC1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] original = Arrays.copyOf(perm,perm.length);
        int cnt = 0;
        int[] arr = new int[n];
        while(!arrEquals(arr,original)) {
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            ++cnt;
            perm = Arrays.copyOf(arr,n);
        }
        return cnt;
    }
    public boolean arrEquals(int[] perm,int[] arr) {
        return Arrays.equals(perm,arr);
    }
}
