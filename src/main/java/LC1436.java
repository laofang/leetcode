import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode1436题，旅行终点站
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 用哈希表，保存路径（都是单链表单向的）
 * 2. 从第一个开始，直到一个城市没有下个对应的目标点，当前城市就是旅行终点站
 */
public class LC1436 {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        for(List<String> cur : paths) {
            map.put(cur.get(0),cur.get(1));
        }
        String key = paths.get(0).get(0);
        String value;
        while ((value = map.get(key)) != null) {
            key = value;
        }
        return key;
    }
}
