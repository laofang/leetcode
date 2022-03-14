import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode599题，两个列表的最小索引总和
 * 关键字：数组、hash、字符串
 * 主要思路：
 * 1. 用Map记录其中一个列表的餐厅的名称和所在索引
 * 2. 遍历另一个列表与前面的map匹配，有几种情况：
 *      1. 如果索引和 > min 直接跳过
 *      2. 如果索引和 == min 向结果加入
 *      3. 如果索引和 < min 清空结果集；更新min;加入当前餐厅名称
 */
public class LC599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            int index = map.getOrDefault(list2[i],-1);
            if(index != -1) {
                if(index + i == min) {
                    ans.add(list2[i]);
                } else if(index + i < min) {
                    ans.clear();
                    min = index + i;
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}
