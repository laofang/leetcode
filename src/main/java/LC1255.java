/**
 * Leetcode1255题，得分最高的单词集合
 * 关键字：位运算、数组、字符串、动态规划、回溯、状态压缩
 * 主要思路：
 * 1. 采用状态压缩，用一个数字来表示选择了words中哪些字符串（对所有字符串进行了组合）
 * 2. 对每种组合情况，进行分数统计，同时对不可能的情况进行排除
 */
public class LC1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] cnt = new int[26];
        for(char ch : letters) {
            cnt[ch - 'a']++;
        }
        int ans = 0;
        for(int c = 1; c < (1 << n); c++) {
            int[] wordCnt = new int[26];
            for(int k = 0; k < n; k++) {
                if((c & (1 << k)) == 0) continue;
                for(char ch : words[k].toCharArray()) {
                    wordCnt[ch - 'a']++;
                }
            }
            int val = 0;
            int i = 0;
            for(; i < cnt.length; i++) {
                if(wordCnt[i] > cnt[i]) break;
                val += wordCnt[i] * score[i];
            }
            if(i == cnt.length) ans = Math.max(val,ans);
        }
        return ans;
    }
}
