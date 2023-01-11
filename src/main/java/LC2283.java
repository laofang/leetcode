/**
 * Leetcode2283题，判断一个数的数字计数是否等于数位的位置
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 就是先进行统计，每个字符出现的数量，再和原字符串进行对比
 */
public class LC2283 {
    public boolean digitCount(String num) {
        int[] map = new int[10];
        for(int i = 0; i < num.length(); i++) {
            map[num.charAt(i) - '0']++;
        }
        for(int i = 0; i < num.length(); i++) {
            if(map[i] != Integer.valueOf(num.charAt(i)-'0')) {
                return false;
            }
        }
        return true;
    }
}
