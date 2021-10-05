/**
 * Leetcode第五题，最长回文子串
 * 使用的中心扩散方法,遍历每一个元素，以第i个元素为中心，向两侧扩散，当两侧元素不等，计算并更新最长字符串
 * 每次遍历时，如果chars[i] == chars[i+1]，则以这两个元素为中心，进行同以上相同的操作。
 */
public class LC5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        String maxString = "";

        //遍历每一个元素
        for (int i = 0; i < chars.length; i++) {
            int leftIndex = i;
            int rightIndex  = i;
            //向两侧扩散
            while(leftIndex >= 0 && rightIndex < chars.length) {
                if(chars[leftIndex] != chars[rightIndex]) {
                    break;
                }
                leftIndex--;
                rightIndex++;
            }
            //更新最长回文子串
            int length = rightIndex - leftIndex - 1;
            if(length > maxLength) {
                maxLength = length;
                maxString = s.substring(leftIndex+1,rightIndex);
            }
            //如果chars[i] == chars[i+1]，则以这两个元素为中心，向两侧扩散
            if(i < chars.length - 1 && chars[i] == chars[i+1]) {
                leftIndex = i;
                rightIndex = i + 1;
                while(leftIndex >= 0 && rightIndex < chars.length) {
                    if(chars[leftIndex] != chars[rightIndex]) {
                        break;
                    }
                    leftIndex--;
                    rightIndex++;
                }
                //更新最长子串
                length = rightIndex - leftIndex - 1;
                if(length > maxLength) {
                    maxLength = length;
                    maxString = s.substring(leftIndex+1,rightIndex);
                }
            }
        }

        return maxString;
    }
}
