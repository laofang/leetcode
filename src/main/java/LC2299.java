/**
 * Leetcode2299题，强密码检验器II
 * 关键字：字符串
 * 主要思路：
 * 1. 状态压缩，按要求检验即可
 */
public class LC2299 {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        int test = 0;
        final int lower = 0;
        final int upper = 1;
        final int number = 2;
        final int special = 3;
        String specialStr = "!@#$%^&*()-+";
        char pre = 'x';
        for(int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if(ch >= '0' && ch <= '9') {
                test = test | (1 << number);
            }
            if(ch >= 'a' && ch <= 'z') {
                test = test | (1 << lower);
            }
            if(ch >= 'A' && ch <= 'Z') {
                test = test | (1 << upper);
            }
            if(specialStr.contains(String. valueOf(ch))) {
                test = test | (1 << special);
            }
            if(i > 0 && ch == pre) return false;
            pre = ch;
        }
        return test == 15;
    }
}
