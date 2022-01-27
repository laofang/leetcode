import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode89题，格雷编码
 * 关键字：编码
 * 主要思路：
 * 1。 第i个码 = i ^ (i >> 1)
 */
public class LC89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < 1 << n;i++) {
            list.add(i ^ (i>>1));
        }
        return list;
    }
}
