import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode118题，杨辉三角
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 当前的行的第i个数字，等于前一行的a[i-1]+a[i]
 */
public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        ans.add(l);
        for(int i = 0; i < numRows - 1; i++) {
            List<Integer> list = ans.get(i);
            List<Integer> newList = new LinkedList<>();
            for(int j = 0; j < list.size(); j++) {

                if(j == 0) {
                    newList.add(1);
                }

                if( j > 0) {
                    newList.add(list.get(j-1) + list.get(j));
                }

                if(j == list.size() - 1) {
                    newList.add(1);
                }

            }
            ans.add(newList);
        }
        return ans;
    }
}
