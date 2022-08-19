import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1656题，设计有序流
 * 关键字：设计、数组、哈希表、数据流
 * 主要思路：
 * 1. 用hash来存每一个(idKey,value)
 * 2. 从ptr开始自增遍历，直到table[ptr] == null停止
 */
public class LC1656 {
    String[] table;
    int ptr;
    List<String> ans;
    public LC1656(int n) {
        table = new String[1001];
        ptr = 1;
        ans = new ArrayList<>(1500);
    }

    public List<String> insert(int idKey, String value) {
        table[idKey] = value;
        ans.clear();
        while(true) {
            if(table[ptr] == null) return ans;
            ans.add(table[ptr]);
            ptr++;
        }
    }
}
