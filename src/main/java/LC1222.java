import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode1222题，可以攻击国王的皇后
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 从国王的位置出发，遍历八个方向，每个方向取第一次遇到的皇后，加入结果集合
 */
public class LC1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[] x = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] y = new int[]{0,1,1,1,0,-1,-1,-1};
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < queens.length; i++) {
            set.add(queens[i][0] * 10 + queens[i][1]);
        }
        for(int i = 0; i < x.length; i++) {
            int[] cur = new int[]{king[0],king[1]};
            while(cur[0] < 8 && cur[1] < 8 && cur[0] >= 0 && cur[1] >= 0) {
                cur[0] += x[i];
                cur[1] += y[i];
                if(set.contains(cur[0] * 10 + cur[1])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur[0]);
                    list.add(cur[1]);
                    ans.add(list);
                    break;
                }
            }
        }
        return ans;
    }
}
