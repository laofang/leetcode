import java.util.Arrays;

/**
 * Leetcode 面试题 01.02，判定是否互为字符重排
 * 关键字: 哈希表、字符串、排序
 * 主要思路:
 * 1. 用两个26长度的数组，每个数组，分别统计每个字符出现的次数
 * 2. 如果最终两个数组相等，则表明两个字符串中的存在的字符和每个不同的字符数量，都是相同的
 */
public class LCInterview0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }
        return Arrays.equals(arr1,arr2);
    }
}
