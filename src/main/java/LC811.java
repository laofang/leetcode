import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Leetcode811题，子域名访问计数
 * 关键字：数组、哈希表、字符串、计数
 * 主要思路：
 * 1. 哈希表记录不同域名的访问次数
 * 2. 对每个字符串进行分割，更新哈希表中的记录
 * 3. 最后将哈希表转换为链表并返回
 */
public class LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder  name = new StringBuilder("");
        for(int i = 0; i < cpdomains.length; i++) {
            String[] temp = cpdomains[i].split("\\s+");
            String[] cur = temp[1].split("\\.");
            name.delete(0,name.length());
            for(int j = cur.length - 1; j >= 0; j--) {
                name = name.toString().equals("") ? name.insert(0,cur[j]) : name.insert(0,".").insert(0,cur[j]);
                int count = map.getOrDefault(name.toString(),0);
                map.put(name.toString(),count+Integer.valueOf(temp[0]));
            }
        }
        return map.entrySet().stream().map(e->e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }
}
