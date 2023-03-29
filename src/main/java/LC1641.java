/**
 * Leetcode1641题，统计字典元音字符串的数目
 * 关键字：数学、动态规划、组合数学
 * 主要思路：
 * 1. 可以找到规律，初始['a','e','i','o','u'],当n为2的时候，'a'可以组合到前一个所有字符的前面，'e'可以组合到除'a'外的所有字符前面，以此类推。
 */
public class LC1641 {
    public int countVowelStrings(int n) {
        int[] curArray = new int[]{1,1,1,1,1};
        int k = 1;
        int sumCur = 5;
        for(k = 1; k < n; k++) {
            int[] newArray = new int[5];
            newArray[0] = sumCur;
            int newSum = sumCur;
            for(int i = 1; i < 5; i++) {
                newArray[i] = sumCur - curArray[i-1];
                newSum += sumCur - curArray[i-1];
                sumCur -= curArray[i-1];
            }
            curArray = newArray;
            sumCur = newSum;
        }
        return sumCur;
    }
}
