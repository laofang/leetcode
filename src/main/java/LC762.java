/**
 * Leetcode762题，二进制表示中质数个计算置位
 * 关键字：位运算、数学
 * 主要思路：
 * 1. int共32位，所以可以将[0,32]范围的质数整理成表
 * 2. 统计每个数字的1的数量，查看是否在表中，汇总统计
 */
public class LC762 {
    static boolean[] map = new boolean[33];
    static {
        int[] nums = new int[]{2,3,5,7,11,13,17,19,23,29,31};
        for(int i = 0; i < nums.length;i++) {
            map[nums[i]] = true;
        }
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int x = left; x <= right;x++) {
            int cnt = 0;
            int y = x;
            while(y != 0) {
                if((y & 1) == 1) cnt++;
                y = y >>> 1;
            }
            if(map[cnt]) ++ans;
        }
        return ans;
    }
}
