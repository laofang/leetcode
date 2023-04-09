/**
 * Leetcode2399题，检查相同字母间的距离
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 计算出现的两个相同字母的距离差，是否符合distance
 */
public class LC2399 {
    public boolean checkDistances(String s, int[] distance) {
        char[] chs = s.toCharArray();
        int[] index = new int[26];
        for(int i = 0; i < chs.length; i++) {
            int k = chs[i] - 'a';
            if(index[k] == 0) {
                index[k] = i + 1;
            } else {
                if(i - index[k] != distance[k])
                    return false;
            }
        }
        return true;
    }
}
