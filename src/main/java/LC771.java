/**
 * Leetcode771题，宝石与石头
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 哈希表记录种类，遍历字符串进行比较
 */
public class LC771 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] map1 = new int[50];
        int[] map2 = new int[50];
        for(char ch : jewels.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                map1[ch - 'a'] = 1;
            } else {
                map2[ch - 'A'] = 1;
            }
        }
        int cnt = 0;
        for(char ch : stones.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                if(map1[ch - 'a'] == 1) cnt++;
            } else {
                if(map2[ch - 'A'] == 1) cnt++;
            }
        }
        return cnt;
    }
}
