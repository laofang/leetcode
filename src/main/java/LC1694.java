/**
 * Leetcode1694题，重新格式化电话号码
 * 关键字：字符串
 * 主要思路：
 * 1. 三个数字一组，然后一个'-'符号。每个字符计数，三个归零
 * 2. 如果最后一次加完数字，若计数为1，说明三个一组后，还剩一个，题目要求最后剩下4个的时候，要两两一组，所以特殊处理即可
 */
public class LC1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                if(cnt == 3) {
                    sb.append("-");
                    cnt = 0;
                }
                cnt++;
                sb.append(number.charAt(i));
            }
        }
        if(cnt == 1) {
            char[] chs = sb.toString().toCharArray();
            char temp = chs[chs.length-2];
            chs[chs.length-2] = chs[chs.length-3];
            chs[chs.length-3] = temp;
            return new String(chs);
        }
        return sb.toString();
    }
}
