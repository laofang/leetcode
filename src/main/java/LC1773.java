import java.util.List;
import java.util.Map;

/**
 * Leetcode1773题，统计匹配检索规则的物品数量
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 简单的根据搜索条件，遍历数据
 * 2. 主要是一个ruleKey到索引的映射，可以用map或者switch等等
 */
public class LC1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String,Integer> map = Map.of("type",0,"color",1,"name",2);
        int index = map.get(ruleKey);
        return (int)items.stream().filter(e -> ruleValue.equals(e.get(index))).count();
    }
}
