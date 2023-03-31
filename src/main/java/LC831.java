/**
 * Leetcode831题，隐藏个人信息
 * 关键字：字符串
 * 主要思路：
 * 1. 按要求进行模拟
 */
public class LC831 {
    public String maskPII(String s) {
        if(isEmail(s)) {
            return maskEmail(s);
        } else {
            return maskPhoneNumber(s);
        }
    }
    public boolean isEmail(String s) {
        return s.contains("@");
    }
    public String maskEmail(String s) {
        String[] strs = s.split("@");
        strs[0] = strs[0].toLowerCase();
        strs[1] = strs[1].toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0].charAt(0));
        sb.append("*****");
        sb.append(strs[0].charAt(strs[0].length() - 1));
        sb.append("@");
        sb.append(strs[1]);
        return sb.toString();
    }
    public String maskPhoneNumber(String s) {
        char[] chs = s.toCharArray();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = chs.length - 1; i >= 0; i--) {
            if(Character.isDigit(chs[i])) {
                cnt++;
                if(cnt <= 4) {
                    sb.append(chs[i]);
                } else {
                    sb.append("*");
                }
                if(cnt == 4 || cnt == 7 || cnt == 10) {
                    sb.append("-");
                }
            }
        }
        if(cnt > 10) {
            sb.append("+");
            sb.reverse();
            return sb.toString();
        } else {
            sb.reverse();
            return sb.substring(1,sb.length());
        }
    }
}
