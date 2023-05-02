import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode970题，强整数
 * 关键字：哈希表、数学
 * 主要思路：
 * 1. 直接根据对数，直接求出x和y的上限，再进行遍历去重比较
 */
public class LC970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int m = x == 1 ? 1 :(int)Math.ceil(Math.log(bound) / Math.log(x)) ;
        int n = y == 1 ? 1 :(int)Math.ceil(Math.log(bound) / Math.log(y)) ;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int v = (int)(Math.pow(x,i) + Math.pow(y,j));
                if(v <= bound) set.add(v);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
}
