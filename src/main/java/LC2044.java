/**
 * Leetcode2044,统计按位或能得到最大的子集数目
 * 关键字：位运算、数组、回溯
 * 主要思路：
 * 1. 二进制枚举，用一个长度为n的整数二进制位，记录选择的元素
 * 2. 将选择的元素进行或操作，更新结果
 */
public class LC2044 {
    public int countMaxOrSubsets(int[] nums) {
        int mask = (1 << nums.length);
        int max = 0;
        int ans = 0;
        for(int i = 0; i < mask;i++) {
            int temp = 0;
            for(int j = 0; j < nums.length;j++) {
                temp = ((i >> j) & 1) == 1 ? temp | nums[j] : temp | 0;
            }
            if(temp > max) {
                max = temp;
                ans = 1;
            } else if( temp == max){
                ans++;
            }
        }
        return ans;
    }
}
