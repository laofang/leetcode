import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode1807题，替换字符串中的括号内容
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 把list中的内容按键值对存储在map里
 * 2. 遍历字符串s，非括号中的内容跟，直接加到待返回的字符串中
 * 3. 找到每个括号对，括号中间内容为键，在map里获取，如果不存在返回"?"，加到待返回字符串中
 */
public class LC1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : knowledge) {
            map.put(list.get(0),list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch == '(') {
                int j = i + 1;
                while(s.charAt(j) != ')') j++;
                String key = s.substring(i+1,j);
                String val = map.getOrDefault(key,"?");
                sb.append(val);
                i = j + 1;
            } else {
                sb.append(ch);
                i++;
            }
        }
        return sb.toString();
    }
}
