import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode1002题，查找共用字符
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 求所有字符串的交集
 */
public class LC1002 {
    public List<String> commonChars(String[] words) {
        int[] tab = new int[26];
        List<String> list = new LinkedList<>();
        char[] chs = words[0].toCharArray();
        for(int i = 0; i < chs.length; i++) {
            tab[chs[i] - 'a']++;
        }
        for(int i = 1; i < words.length; i++) {
            char[] chsTemp = words[i].toCharArray();
            int[] temp = new int[26];
            for(int j = 0; j < chsTemp.length; j++) {
                int index = chsTemp[j] - 'a';
                if(tab[index] > 0) {
                    temp[index]++;
                    tab[index]--;
                }
            }
            tab = temp;
        }
        for(int i = 0; i < tab.length; i++) {
            while(tab[i] > 0) {
                list.add((char)('a' + i) + "");
                tab[i]--;
            }
        }
        return list;
    }
}
