import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1705题，字母与数字
 * 关键字：数组、哈希表、前缀和
 * 主要思路：
 * 1. 前缀和，如果两个位置之前的数字数量和字母数量之差相等，说明两个位置之间的数字数量和字母数量相等
 */
public class LCInterview1705 {
    public String[] findLongestSubarray(String[] array) {
        int chCnt = 0;
        int numCnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] pos = new int[3];
        for(int i = 0; i < array.length; i++) {
            String str = array[i];
            if(isNumberic(str)) {
                numCnt++;
            } else {
                chCnt++;
            }
            if(chCnt == numCnt) {
                pos[0] = -1;
                pos[1] = i;

            } else {
                Integer start = map.get(chCnt - numCnt);
                if(start != null) {
                    if(i - start > pos[1] - pos[0] + 1) {
                        pos[0] = start;
                        pos[1] = i;
                    }
                } else {
                    map.put(chCnt - numCnt,i);
                }
            }
        }
        pos[0]++;
        int cnt = pos[1] - pos[0] + 1;
        if(cnt > 1) {
            String[] strs = Arrays.copyOfRange(array,pos[0],pos[1] + 1);
            return strs;
        }
        return new String[0];
    }
    public boolean isNumberic(String str) {
//        return str != null && str.chars().allMatch(Character::isDigit);
        char[] chs = str.toCharArray();
        for(char ch : chs) {
            if(!Character.isDigit(ch)) return false;
        }
        return true;
    }
}
