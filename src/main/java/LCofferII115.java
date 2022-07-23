import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 剑指offer II 115题，重建序列
 * 关键字：图、拓扑排序、数组
 * 主要思路：
 * 1. 根据已知的序列建图
 * 2. 再根据给定的超序列，在图中搜索，是否有一条与超序列相同的路径，也就是按图索骥
 */
public class LCofferII115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sequences.length; i++) {
            for (int j = 1; j < sequences[i].length; j++) {
                List<Integer> list = map.getOrDefault(sequences[i][j-1],new LinkedList<>());
                list.add(sequences[i][j]);
                map.put(sequences[i][j-1],list);
            }
        }
        List<Integer> lt = map.get(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(lt == null || lt.size() == 0) return false;
            if(!lt.contains(nums[i])) return false;
            lt = map.get(nums[i]);
        }
        return true;
    }
}
