/**
 * Leetcode1550题，存在连续三个奇数的数
 * 关键字：数组
 * 主要思路：
 * 1. 三个数，三个数的遍历检验，存在符合要求的返回true，否则返回false
 */
public class LC1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1) return true;
        }
        return false;
    }
}
