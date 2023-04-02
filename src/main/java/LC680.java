/**
 * Leetcode
 */
public class LC680 {
    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        int times = 0;
        while(l < r) {
            if(chs[l] == chs[r]) {
                l++;
                r--;
            } else {
                if(times > 0) return false;
                if(l + 1 <= r) {
                    if(chs[l+1] == chs[r]) {
                        l = l + 2;
                        r--;
                    } else if(chs[l] == chs[r-1]) {
                        r = r - 2;
                        l++;
                    } else {
                        return false;
                    }
                }
                times++;
            }
        }
        return true;
    }
}
