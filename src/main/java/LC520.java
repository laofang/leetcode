/**
 * Leetcode520题，检测大写字母
 * 关键字：字符串
 * 主要思路：
 * 1. 用bit位做标志，位运算即可
 */
public class LC520 {
    public boolean detectCapitalUse(String word) {
        //全是大写字母、全是小写字母、大于一个字母时，只有首字母大写
        char flag = 0;
        for (int i = 0; i < word.length(); i++) {
            if(i == 0 && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                flag =  (char)(flag | 0b100);
            } else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                flag =  (char)(flag | 0b10);
            } else {
                flag =  (char)(flag | 0b1);
            }
        }
//        System.out.println(flag+0);
        //1. 110首字母大写，其余小写  //101
        return flag == 6 || flag == 5 || flag == 2 || flag == 4? true : false;
    }
}
