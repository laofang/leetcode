/**
 * Leetcode917题，仅仅反转字母
 * 关键字：字符串、双指针
 * 主要思路：
 * 1. 双指针分别从左和右向中间遍历
 * 2. 如果不是字母就跳过，如果是字母停止
 * 3. 左右指针内容交换，继续这个过程，知道左右指针相等
 */
public class LC917 {
    public String reverseOnlyLetters(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] arrays = s.toCharArray();
        while(l < r) {
            while(l < r && ((arrays[l] < 'a' && arrays[l] > 'Z') || arrays[l] < 'A' || arrays[l] > 'z')) {
                l++;
            }
            while(r > l && ((arrays[r] < 'a' && arrays[r] > 'Z') || arrays[r] < 'A' || arrays[r] > 'z')) {
                r--;
            }
            char temp = arrays[l];
            arrays[l] = arrays[r];
            arrays[r] = temp;
            l++;
            r--;
        }
        return new String(arrays);
    }
}
