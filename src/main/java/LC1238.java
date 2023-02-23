import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1238题，循环码排列
 * 关键字：位运算、数学、回溯
 * 主要思路：
 * 1. 参考了LC89，格雷编码
 * 2. 按 i ^ (i>>1)的公式生成n个数，再根据开始的参数，分两段装配
 */
public class LC1238 {
    public List<Integer> circularPermutation(int n, int start) {
        int[] value = new int[1 << n];
        for(int i = 0; i < 1 << n; i++) {
            value[i] = i ^ (i >> 1);
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for(; i < value.length;i++) {
            if(value[i] == start) break;
        }
        int m = i;
        for(; i < value.length;i++) {
            list.add(value[i]);
        }
        for(int k = 0; k < m; k++) {
            list.add(value[k]);
        }
        return list;
    }
}
