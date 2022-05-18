/**
 * Leetcode205题，同构字符串
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 创建两个数组，
 * 2. 一个记录前一个字符串的字符->后一个字符串字符的映射关系
 * 3. 另一个记录是否后一个字符串的字符是否建立过映射关系
 * 4. 如果映射关系存在，映射的字符发生变化，返回false;
 * 5. 如果映射关系不存在，但被映射的字符已经建立过映射关系，也返回false；
 */
public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] map = new int[128];
        int[] tMap = new int[128];

        for(int i = 0; i < n;i++) {
            char ch = s.charAt(i);
            if(map[ch + 1] == 0) {
                if(tMap[t.charAt(i) + 1 ] != 0) return false;
                tMap[t.charAt(i) + 1] = 1;
                map[ch + 1] = t.charAt(i) + 1;
                continue;
            }
            if(map[ch + 1] != t.charAt(i) + 1) return false;
        }
        return true;
    }
}
