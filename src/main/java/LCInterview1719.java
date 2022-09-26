/**
 * Leetcode 面试题 17.19，消失的两个数字
 * 关键字：位运算、数组、哈希表
 * 主要思路：
 * 1. 将当前数组和[1,N]进行异或操作，结果就是x = x1 ^ x2(x1和x2就是要求的两个数)；
 * 2. x是两个数异或的结果，表明x中二进制位为1的地方，就是x1和x2不同的地方，选择最低位不同的地方进行分组；
 * 3. 待分组数组是nums和[1,N]的全体，分组结果会是 第一组包含x1（或x2）除了x1（或x2）外，其余全部成对出现，第二组与其类似；
 * 4. 分组全体元素进行异或，结果就是x1和先x；
 */
public class LCInterview1719 {
    public int[] missingTwo(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length + 2; i++) {
            if(i < nums.length) x ^= nums[i];
            x ^= (i+1);
        }
        int test = 1;
        while((test & x) == 0) {
            test <<= 1;
        }
        int[] ans = new int[2];
        for(int i = 0; i < nums.length + 2; i++) {
            if(((test) & (i+1)) == 0) {
                ans[0] ^= (i+1);
            } else {
                ans[1] ^= (i+1);
            }
            if(i < nums.length) {
                if((test & nums[i]) == 0) {
                    ans[0] ^= nums[i];
                } else {
                    ans[1] ^= nums[i];
                }
            }
        }
        return ans;
    }
}
