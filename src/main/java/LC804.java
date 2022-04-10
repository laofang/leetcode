import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode804题，唯一摩尔斯密码词
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 把每个字符串转换成摩斯码字符串
 * 2. 如果记录中不存在当前摩斯码，计数加一，并进行记录
 */
public class LC804 {
    final static String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
//        Set<String> set = new HashSet<>();
        int ans = 0;
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                sb.append(morse[ch-'a']);
            }
//            set.add(sb.toString());
            if(map.get(sb.toString()) == null) {
                map.put(sb.toString(),1);
                ans++;
            }
        }
        return ans;
    }
}
