/**
 * Leetcode476题，数字的补数
 * 关键字：位运算
 * 主要思路：
 * 1. 跳过前导零，然后对应是0的位，答案对应位填上1
 */
public class LC476 {
    public int findComplement(int num) {
        int ans = 0;
        int test = 1;
        int i = 31;
        //跳过前导零
        while(( (test << i) & num) == 0) i--;
        //如果是0的位，答案的对应位填上1
        for(; i >= 0; i--) {
            if( ((test << i) & num) == 0) {
                ans = (test << i) | ans;
            }
        }
        return ans;
    }
}
