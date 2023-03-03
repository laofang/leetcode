import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1487题，保证文件名唯一
 * 关键字：数组、哈希表、字符串
 * 主要思路：
 * 1. 用hash记录，已经生成的文件名，出现相同的，就顺次后移，并将新的后缀进行记录
 */
public class LC1487 {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for(int i = 0; i < names.length; i++) {
            int val = map.getOrDefault(names[i],1);
            String temp = names[i];
            StringBuilder sb = new StringBuilder(names[i]);
            while(map.get(temp) != null) {
                temp = sb.append("(").append(val).append(")").toString();
                val++;
                sb = new StringBuilder(names[i]);
            }
            ans[i] = temp;
            map.put(names[i],val);
            if(!temp.equals(names[i])) map.put(temp,1);
        }
        return ans;
    }
}
