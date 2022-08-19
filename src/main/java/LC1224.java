/**
 * Leetcode1224题，最大相等概率
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 分析满足要求的前缀的几种情况
 *      1. 所有数字只出现一次例如[1,2,3,4,5,6]
 *      2. 有一个数字出现一次，其他数字出现次数相等[1,2,1,2,3,3,4]
 *      3. 只有一个数字出现次数最多，最多次数max，其他数字出现次数为max-1
 * 2. 设计三个变量，通过变量运算验证上面三种情况
 *      1. cnt[i] 记录数字i出现的次数
 *      2. sum[i] 记录出现次数为i的数字有几个
 *      3. max 记录出现次数最多的数字
 */
public class LC1224 {
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100001];
        int[] sum = new int[100001];
        int max = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            cnt[value]++;
            sum[cnt[value]]++;
            max = Math.max(max,cnt[value]);
            //出现最多次数为1，说明遍历过的字符长度都是1
            if(max == 1) ans = i + 1;
            //对应[1,1,2,2,3]这种情况，最大长度 * 最大长度字符的个数 + 只出现一次的字符
            if(max * sum[max] + 1 == i + 1) ans = i + 1;
            //对应[1,1,2,2,3,3,3]，最大长度-1 * 次大长度出现的个数（出现次数为K的数字，在[1,k)中也被记录过） + 出现最多数字多出现的一次
            if((max - 1) * sum[max-1] + 1 == i + 1) ans = i + 1;
        }
        return ans;
    }
}

