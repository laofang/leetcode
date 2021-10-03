import java.util.HashMap;

/**
 * Leetcode第三题，无重复最长子串
 * 用时23m10s
 */
public class LC3 {
    /**
     * 整体思路：动态窗口，对新进入的元素进行判断，如果在窗口中有重复元素，则窗口起始移动到窗口重复的下一个元素
     * 注意事项：1.一个元素的情况；2. 每次最大长度是在有重复元素时计算，所以要注意最后一个元素没有重复的情况
     * 出现错误的地方：
     * 1. char的包装器类是Character而不是Char
     * 2. 每次新元素检查完毕未加入map中
     * 3. 最后一个元素未出现重复，循环结束后要重新计算一次并比较
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> valueIndexMap = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        int sIndex = 0;
        int cIndex = 0;
        int maxLength = 0;
        if(chars.length == 1) {
            return 1;
        }
        for(cIndex = 0; cIndex < chars.length; cIndex++) {
            Integer index = valueIndexMap.get(chars[cIndex]);
            if(index != null && index >= sIndex) {
                maxLength = maxLength > cIndex - sIndex ? maxLength : cIndex - sIndex;
                sIndex = index + 1;
            }
            valueIndexMap.put(chars[cIndex],cIndex);
        }

        return maxLength > cIndex - sIndex ? maxLength : cIndex - sIndex;

    }
}
