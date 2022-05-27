/**
 * Leetcode 面试题 17.11，单词距离
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 双指针，一个指向单词1，另一个指向单词2
 * 2. 遍历，一旦当前的是单词1或单词2，更新指针，然后求距离，如果小于当前距离更新结果
 */
public class LCInterview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int w1 = -1;
        int w2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                w1 = i;
                if(w1 != -1 && w2 != -1) {
                    min = Math.min(Math.abs(w2 - w1),min);
                }
            }
            if(words[i].equals(word2)) {
                w2 = i;
                if(w1 != -1 && w2 != -1) {
                    min = Math.min(Math.abs(w2 - w1),min);
                }
            }
        }
        return min;
    }
}
