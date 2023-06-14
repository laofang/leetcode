/**
 * Leetcode1375题，二进制字符串前缀一致的次数
 * 关键字：数组
 * 主要思路：
 * 1. 遍历，如果当前位置前缀都被反转，那么当前位置索引>=前缀最大值
 */
public class LC1375 {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < flips.length; i++) {
            max = Math.max(flips[i],max);
            if(i+1 >= max) ans++;
        }
        return ans;
    }
}
