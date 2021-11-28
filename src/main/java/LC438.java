import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode438题，找到字符串中所有字母异位词
 * 关键字：字符串、异位词、词频、窗口
 * 主要思路：
 * 1. 移动窗口，检测当前窗口内的字符串的词频和指定串的词频是否相等
 * 2. 可以优化，每次窗口移动的时候是左侧的抛弃，右侧的进入，所以对偏移进行修改即可，如果偏移数组绝对值和为0，则是异位词
 */
public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        //s的长度小于p，就不存在异位词
        if(s.length() < p.length()) {
            return Collections.emptyList();
        }
        //偏移
        int[] offsetArray = new int[26];
        int left = 0;
        int right = p.length() - 1;
        List<Integer> ans = new LinkedList<>();
        //p串中的词频
        for (int i = 0; i < p.length(); i++) {
            offsetArray[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < right; i++) {
            offsetArray[s.charAt(i) - 'a']--;
        }
        int sum = 0;
        while(right < s.length()) {
            if (left != 0) {
                if (sum == 0 && s.charAt(left - 1) == s.charAt(right)) {
                    ans.add(left);
                    left++;
                    right++;
                    continue;
                }
                offsetArray[s.charAt(left - 1) - 'a']++;
            }
            offsetArray[s.charAt(right) - 'a']--;

            sum = 0;
            for (int j = 0; j < offsetArray.length; j++) {
                sum+=Math.abs(offsetArray[j]);
            }
            if(sum == 0) {
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }
}
