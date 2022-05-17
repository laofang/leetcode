/**
 * Leetcode953题，验证外星语词典
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 对给定的顺序的字符串的每个字符建立索引
 * 2. 循环比较字符串数组相邻的两个字符串
 *      1. 同时遍历两个字符串，并进行比较
 *      2. 如果前一个字符串当前位置字符索引大于后一个字符串当前位置索引，直接返回false;
 *      3. 如果 pre[index] < cur[index]，跳出比较，再比较下一对相邻的字符串
 *      4. 如果index > cur.length，也返回falses（前缀相同，但后面的长度更短，应放在前面）
 */
public class LC953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] table = new int[26];
        for (int i = 0; i < order.length(); i++) {
            table[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++) {
            for(int j = 0; j < words[i - 1].length();j++) {
                if(j >= words[i].length()) return false;
                int preIndex = words[i-1].charAt(j) - 'a';
                int curIndex = words[i].charAt(j) - 'a';
                if(table[preIndex] > table[curIndex]) return false;
                if(table[preIndex] < table[curIndex]) break;
            }
        }
        return true;
    }
}
