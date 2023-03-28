/**
 * Leetcode696题，最短公共超序列
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 找到'01'或'10'位置，再向两端扩展，结果进行增量更新
 * 2. 又更好的做法，对字符进行分段统计，如'010011100'，记作[1,1,2,3,2]，再进行统计就很方便
 */
public class LC696 {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '1') {
                int l = i - 1;
                int r = i + 2;
                ans++;
                while(l >= 0 && r < s.length()) {
                    if(s.charAt(l--) == '0' &&  s.charAt(r++) == '1') {
                        ans++;
                    }else {
                        break;
                    }
                }
            } else if(s.charAt(i) == '1' && s.charAt(i+1) == '0') {
                int l = i - 1;
                int r = i + 2;
                ans++;
                while(l >= 0 && r < s.length()) {
                    if(s.charAt(l--) == '1' &&  s.charAt(r++) == '0') {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
