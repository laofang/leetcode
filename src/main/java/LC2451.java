import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode2451题，差值数组不同的字符串
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 用哈希表进行记录，每个数组都减第一个字符，出现的次数为一次的就是对应的字符串
 */
public class LC2451 {
    public String oddString(String[] words) {
        Map<String,int[]> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            char ch = chs[0];
            for(int j = 0; j < chs.length; j++) {
                chs[j] = (char)(chs[j] - ch + 'a');
            }
            String str = new String(chs);
            int[] v = map.getOrDefault(str,new int[2]);
            v[0] = i;
            v[1]++;
            map.put(str,v);
        }
        for(Map.Entry<String,int[]> e : map.entrySet()) {
            int[] v = e.getValue();
            if(v[1] == 1) {
                return words[v[0]];
            }
        }
        return "";
    }
}
