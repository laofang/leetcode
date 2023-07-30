/**
 * Leetcode1528题，重新排列字符串
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 冒泡排序
 */
public class LC1528 {
    public String restoreString(String s, int[] indices) {
        char[] chs = s.toCharArray();
        for(int i = 0; i < indices.length; i++) {
            for(int j = 0; j < indices.length - i - 1; j++) {
                if(indices[j] > indices[j+1]) {
                    int temp = indices[j];
                    indices[j] = indices[j+1];
                    indices[j+1] = temp;

                    char ch = chs[j];
                    chs[j] = chs[j+1];
                    chs[j+1] = ch;
                }
            }
        }
        return new String(chs);
    }
}
