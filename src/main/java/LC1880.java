/**
 * Leetcode1880题，检查某单词是否等于两单词之和
 * 关键字：字符串
 * 主要思路：
 * 1. 写一个字符串按规则转换数字的方法，然后判断两数之和是否和目标数字向相等
 */
public class LC1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return transformNum(firstWord) + transformNum(secondWord) == transformNum(targetWord);
    }
    public int transformNum(String word) {
        int num = 0;
        for(int i = 0; i < word.length(); i++) {
            num = num * 10 + word.charAt(i) - 'a';
        }
        return num;
    }
}
