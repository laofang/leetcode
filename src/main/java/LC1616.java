/**
 * Leetcode1616题，分割两个字符串得到回文串
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 先统计a的前缀和b的后缀有多少相同，同样的，也要求出b的前缀和a的前缀相同的数量，最大数量设为len
 * 2. 再统计a中心回文字符串长度，b中心回文字符串长度，其中最长的设为len1
 * 3. 如果len + len1 >= n，说明可以根据规则构成回文串，反之则不能
 */
public class LC1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        int n = a.length();
        int l = 0;
        int r = n - 1;
        char[] chsA = a.toCharArray();
        char[] chsB = b.toCharArray();
        boolean isOdd = n % 2 == 1;

        int length = getLength(chsA,chsB);
        length = Math.max(length,getLength(chsB,chsA));
        int length2 = Math.max(getCentralPalindrome(chsA),getCentralPalindrome(chsB));
        return length + length2 >= n;

    }
    //a的前缀和b的后缀，回文长度
    public int getLength(char[] a, char[] b) {
        if(a.length != b.length) return -1;
        int n = a.length;
        int l = 0;
        int r = n - 1;
        int length = 0;
        while(l < r) {
            if(a[l++] != b[r--]) break;
            length += 2;
        }
        //长度奇数，并且全部回文
        if(l == r) length++;
        return length;
    }
    //字符串chs中心回文长度
    public int getCentralPalindrome(char[] chs) {
        int length = 0;
        final boolean isOdd = chs.length % 2 == 1;
        int idx = (chs.length - 1) / 2;
        if(isOdd) {
            int l = idx - 1;
            int r = idx + 1;
            length = 1;
            while(l >= 0 && r <= chs.length - 1) {
                if(chs[l--] != chs[r++]) break;
                length += 2;
            }
        } else{
            if(chs[idx] == chs[idx+1]) {
                length = 2;
                int l = idx - 1;
                int r = idx + 2;
                while (l >= 0 && r <= chs.length - 1) {
                    if (chs[l--] != chs[r++]) break;
                    length += 2;
                }
            }
        }
        return length;
    }
}
