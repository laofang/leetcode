import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode1200题，最小绝对差
 * 关键字：数组、排序
 * 主要思路：
 * 1. 最小差值只能出现在排序后相邻的两个数的差之中
 * 2. 所以先排序，再遍历，如果差值cur==min,就记录进答案；如果cur < min，清理答案记录，从新开始。
 * 注意事项：
 * List removeAll和clear方法的不同
 */
public class LC1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length;i++) {
            int cur = arr[i] - arr[i-1];
            if(cur <= min) {
                if(cur < min) ans.clear();
                min = cur;
                List<Integer> l = new ArrayList<>();
                l.add(arr[i-1]);
                l.add(arr[i]);
                ans.add(l);
            }
        }
        return ans;
    }
}
