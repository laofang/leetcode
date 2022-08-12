import java.util.*;

/**
 * Leetcode1282题，用户分组
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 由map持有不同大小的组，同时将这些组加入到列表中
 * 2. 遍历一个数字，将改数字加入指定的组，如果组不存在，就创建新组
 */
public class LC1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < groupSizes.length; i++) {
            int gNum = groupSizes[i];
            List<Integer> group = map.getOrDefault(gNum,new ArrayList(gNum));
            if(group.size() == gNum) {
                group = new ArrayList(gNum);
            }
            if(group.size() == 0) {
                map.put(gNum,group);
                ans.add(group);
            }
            group.add(i);
        }
        return ans;
    }
}
