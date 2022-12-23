import java.util.Arrays;

/**
 * Leetcode2011题，执行操作后的变量值
 * 关键字：数组、字符串、模拟
 * 主要思路：
 * 1. 简单题，根据每个字符串的前后字符，进行加减
 */
public class LC2011 {
    static int ans;
    public int finalValueAfterOperations(String[] operations) {
        ans = 0;
        Arrays.stream(operations).forEach(str -> {
            ans = str.charAt(0) == '+' || str.charAt(str.length()-1) == '+' ? ++ans : --ans;
        });
        return ans;
    }
}
