/**
 * Leetcode383题，赎金信
 * 关键字：字符串、哈希
 * 主要思路：
 * 1. 这题不说也罢
 */
public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //记录magazine每个字母的数量
        int[] abcs = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            abcs[magazine.charAt(i) - 'a']++;
        }
        //ransomNote用一个少一个，直到不够用，返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            int target = ransomNote.charAt(i) - 'a';
            abcs[target]--;
            if (abcs[target] < 0) {
                return false;
            }
        }
        return true;
    }
}
