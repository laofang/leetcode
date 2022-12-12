/**
 * Leetcode1781题，所有子字符串美丽值之和
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 暴力双重循环，i确定头的位置，j>i，遍历作为不同的尾的位置
 * 2. 每一次的i，都用同一个table记录字符出现的次数
 */
public class LC1781 {
    public int beautySum(String s) {
        char[] chs = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < chs.length; i++) {
            int[] table = new int[26];
            for(int j = i; j < chs.length; j++) {
                table[chs[j] - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < table.length; k++) {
                    if(table[k] > 0) {
                        max = Math.max(max,table[k]);
                        min = Math.min(min,table[k]);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}
