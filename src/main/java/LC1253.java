import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1253题，重构2行二进制矩阵
 * 关键字：贪心、数组、矩阵
 * 主要思路：
 * 1. 贪心，如果colsum对应位置是2，upper和lower都要-1,同时对应位置置1
 * 2. 如果colsum对应位置是2，upper和lower中较小的一个减1，加到答案对应的位置
 */
public class LC1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] ans = new int[2][colsum.length];
        List<List<Integer>> ansL = new ArrayList<>();
        for(int i = 0; i < colsum.length; i++) {
            if(colsum[i] == 2) {
                upper--;
                lower--;
                ans[0][i] = 1;
                ans[1][i] = 1;
            } else if(colsum[i] == 1) {
                if(upper >= lower) {
                    upper--;
                    ans[0][i] = 1;
                }else {
                    lower--;
                    ans[1][i] = 1;
                }
            }

            if(upper < 0 || lower < 0) return ansL;
        }

        if(upper != 0 || lower != 0) {
            return ansL;
        }
        for(int i = 0; i < 2; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < colsum.length; j++) {
                list.add(ans[i][j]);
            }
            ansL.add(list);
        }
        return ansL;
    }
}
