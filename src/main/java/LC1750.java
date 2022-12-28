/**
 * Leetcode1750题，删除字符串两端相同字符串后的最短长度
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 双指针，分别指向开始和末尾，指针指向的字母相同，前后进行收缩
 */
public class LC1750 {
    public int minimumLength(String s) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length-1;
        while(l < r) {
            if(chs[l] != chs[r]) break;
            while(l < r && chs[l] == chs[l+1]) l++;
            ++l;
            if(l >= r) break;
            while(l < r && chs[r] == chs[r-1]) r--;
            --r;
        }
        return r - l + 1;
    }
}
