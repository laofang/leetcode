import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode1233题，删除子文件夹
 * 关键字：字典树、数组、字符串
 * 主要思路：
 * 1. 排序，双直至，如果右指针以左指针的字符串+”/"作为前缀，右指针的字符串就是做指针位置的子文件夹
 * 2. 如果，右指针位置不以左指针位置字符串为前缀，说明右指针是一个根文件夹，左指针指向这个位置，右指针右移
 */
public class LC1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int left = 0;
        int right = 0;
        List<String> ans = new ArrayList<>();
        while(right < folder.length && left < folder.length) {
            if(right == 0) {
                ans.add(folder[right]);
            } else if(!folder[right].startsWith(folder[left] + "/")) {
                ans.add(folder[right]);
                left = right;
            }
            ++right;
        }
        return ans;
    }
}
