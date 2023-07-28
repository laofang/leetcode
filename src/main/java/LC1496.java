import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode1496题，判断路径是否相交
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 每次走的位置都查看是否走过，没走过就记录
 */
public class LC1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        char[] chs = path.toCharArray();
        int[] cur = new int[]{0,0};
        set.add(cur[0] + " " + cur[1]);
        StringBuilder key = new StringBuilder();
        for(int i = 0; i < chs.length; i++) {
            int[] x = f(chs[i]);
            cur[0] += x[0];
            cur[1] += x[1];
            key.append(cur[0]).append(" ").append(cur[1]);
            if(set.contains(key.toString())) return true;
            set.add(key.toString());
            key.setLength(0);
        }
        return false;
    }
    public int[] f(char p) {
        switch(p) {
            case 'N' :
                return new int[]{0,1};
            case 'S' :
                return new int[]{0,-1};
            case 'E' :
                return new int[]{1,0};
            case 'W' :
                return new int[]{-1,0};
            default:
                return new int[]{0};
        }
    }
}
