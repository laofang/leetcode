import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1072题，案列翻转得到最大值等行数
 * 关键字：数组、哈希表、矩阵
 * 主要思路：
 * 1. 在列可以翻转的前提下，行'101'本质和行'010'是相同的，可以通过翻转列相互得到
 * 2. 所以可以将最高位是1的转化为本质串最高位是0的，统计相同本质串的数量，其中最大的就是答案
 */
public class LC1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}
