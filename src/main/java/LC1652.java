/**
 * Leetcode1652题，拆炸弹
 * 关键字：数组
 * 主要思路：
 * 1. 将两个code数组组合成一个数组，然后求前缀和
 * 2. 根据前缀和的差，来求当前第i个元素，前k个或后k个元素的和
 */
public class LC1652 {
    public int[] decrypt(int[] code, int k) {
        if(k == 0) return new int[code.length];
        int[] sumArray = new int[code.length * 2];
        int sum = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < code.length; j++) {
                sum += code[j];
                sumArray[i * code.length + j] = sum;
            }
        }
        int[] ans = new int[code.length];
        if(k > 0) {
            for(int i = 0; i < code.length; i++) {
                ans[i] = sumArray[i+k] - sumArray[i];
            }
        }
        if(k < 0) {
            for(int i = 0; i < code.length; i++) {
                ans[i] = sumArray[code.length + i - 1] - sumArray[code.length + i + k - 1];
            }
        }
        return ans;
    }
}
