import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode1376题，通知所有员工所需的时间
 * 关键字：树、深度优先搜索、广度优先搜索
 * 主要思路：
 * 1. 构造树，然后深度搜索递归
 * 2. 可以这样思考，当前管理者要通知所有下属所需要的时间，等于他的所有下属中花费时间最多通知他的下属的那个时间 + 当前管理者通知下属所化的时间
 * 3. time = curTime + max(curManager所有下属通知完毕所花时间），明显的递归
 */
public class LC1376 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for(int i = 0; i < manager.length; i++) {
            List<Integer> list = map.getOrDefault(manager[i],new ArrayList<>());
            list.add(i);
            map.put(manager[i],list);
        }
        return getTime(map.get(-1).get(0),informTime);
    }
    public int getTime(int id,int[] informTime) {
        List<Integer> list = map.get(id);
        if(list == null) return 0;
        int max = 0;
        for(Integer em : list) {
            int time = getTime(em,informTime);
            max = Math.max(time,max);
        }
        return max + informTime[id];
    }
}
