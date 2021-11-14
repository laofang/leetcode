import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode677题，键值映射
 * 关键字：哈希
 * 主要思路：
 * 1. 一个map维护key,val
 * 2. 一个map维护key的前缀和
 */
public class LC677 {
    private Map<String,Integer> preMap;
    private Map<String,Integer> keyMap;
    public LC677() {
        preMap = new HashMap<>();
        keyMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        char[] chs = key.toCharArray();
        //原来提供的价值
        int original = keyMap.getOrDefault(key,0);
        keyMap.put(key,val);
        for (int i = 0; i < chs.length; i++) {
            //每一个前缀
            char[] temp = Arrays.copyOf(chs,i+1);
            String preKey = String.valueOf(temp);
            //前缀的值
            Integer count = preMap.getOrDefault(preKey,0);
            if(count > 0) {
                //减去原本提供的价值
                count -= original;
            }
            count += val;
            preMap.put(preKey,count);
        }
    }

    public int sum(String prefix) {
        return preMap.getOrDefault(prefix,0);
    }
}
