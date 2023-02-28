import java.util.*;

/**
 * Leetcode2363题，合并相似的物品
 * 关键字：数组、哈希表、有序集合、排序
 * 主要思路：
 * 1. 使用hash表，先遍历items1，对与items1与items2都存在的值，进行合并。
 * 2. 再遍历items2，如果items2存在的，items1不存在，就直接加入答案列表，最后再排序。
 */
public class LC2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < items1.length;i++) {
            map1.put(items1[i][0],items1[i][1]);
        }
        for(int j = 0; j < items2.length;j++) {
            map2.put(items2[j][0],items2[j][1]);
        }
        for(int i = 0; i < items1.length;i++) {
            int val = map2.getOrDefault(items1[i][0],0);
            List<Integer> list = new ArrayList<>();
            list.add(items1[i][0]);
            list.add(items1[i][1] + val);
            ans.add(list);
        }
        for(int j = 0; j < items2.length; j++) {
            if(map1.get(items2[j][0]) != null) continue;
            List<Integer> list = new ArrayList<>();
            list.add(items2[j][0]);
            list.add(items2[j][1]);
            ans.add(list);
        }
        Collections.sort(ans, Comparator.comparingInt(e -> e.get(0)));
        return ans;
    }
}
