/**
 * Leetcode第五题，最长回文子串
 * 使用的中心扩散方法,遍历每一个元素，以第i个元素为中心，向两侧扩散，当两侧元素不等，计算并更新最长字符串
 * 每次遍历时，如果chars[i] == chars[i+1]，则以这两个元素为中心，进行同以上相同的操作。
 *
 * 使用动态规划方法
 */
public class LC5 {
    /**
     * 使用中心扩散方法查找最长回文子串
     * 注意事项：
     * 1. 中心可能有奇数和偶数两种情况
     */
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

    /**
     * 使用动态规划来计算最长回文子串
     * p[i][j]如果是回文子串，则dp[i+1][j-1]是真且s[i] == s[j]
     * 注意事项：
     * 1。 注意特殊情况，i==j和i+1==j
     * 2. 注意循环方式，计算当前元素，要已经获取左下的元素
     */
    public String longestPalindromeDP(String s) {
        int sLength = s.length();
        char[] chars = s.toCharArray();
        boolean dp[][] = new boolean[sLength][sLength];
        int jStart = 0;

        int maxLength = 0;
        String maxString = "";
        while(jStart < sLength) {
            int i = 0;
            int j = jStart;
            while(j < sLength) {
                if(i == j) {
                    dp[i][j] =true;
                    if(j - i + 1 > maxLength) {
                        maxString = s.substring(i,j+1);
                    }
                }
                else if(i + 1 == j && chars[i] == chars[j]) {
                    dp[i][j] =true;
                    if(j - i + 1 > maxLength) {
                        maxString = s.substring(i,j+1);
                    }
                }
                else if(chars[i] == chars[j] && dp[i+1][j-1]) {
                    dp[i][j] =true;
                    if(j - i + 1 > maxLength) {
                        maxString = s.substring(i,j+1);
                    }
                }
                i++;
                j++;
            }
            jStart++;
        }
        return maxString;
    }
}
