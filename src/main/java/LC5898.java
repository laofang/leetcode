import java.util.HashMap;
import java.util.Map;

/**
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 *
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 *
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：arr = ["d","b","c","b","c","a"], k = 2
 * 输出："a"
 * 解释：
 * arr 中独一无二字符串包括 "d" 和 "a" 。
 * "d" 首先出现，所以它是第 1 个独一无二字符串。
 * "a" 第二个出现，所以它是 2 个独一无二字符串。
 * 由于 k == 2 ，返回 "a" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-distinct-string-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC5898 {
    //对每个进行字符串进行计数，在遍历第k个只出现了一次的字符串
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> logM = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            count =logM.getOrDefault(arr[i],0);
            count++;
            logM.put(arr[i],count);
        }
        count = 0;
        for(int i = 0; i < arr.length; i++) {
            int v = logM.get(arr[i]);
            if(v == 1){
                count++;
                if(count == k) {
                    return arr[i];
                }
            }
        }
        return "";
    }
}
