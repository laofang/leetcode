/**
 * Leetcode1625题，执行操作后字典序最小的字符串
 * 关键字：广度优先搜索、字符串
 * 主要思路：
 * 1. 纯暴力解法，设每次轮转后的字符串为t
 * 2. 对每个t进行如下操作，奇数位加9次a，如果b % 2 == 1，那么9次加a的每一次之下，也要对偶数维9次加a
 * 3. 从中选取字典序最小的那一个
 */
public class LC1625 {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        int[] vis = new int[n];
        String str = s + s;
        int i = 0;
        String ans = s;

        while(vis[i] != 1) {
            char[] t = str.substring(i, i + n).toCharArray();
            vis[i] = 1;
            i = (i + b) % n;
            for(int j = 0; j < 10; j++) {
                if(j != 0) {
                    for (int k = 1; k < n; k += 2) {
                        t[k] = (char) ('0' + (t[k] - '0' + a) % 10);
                    }
                }
                if(b % 2 == 1) {
                    for(int p = 0; p < 10; p++) {
                        if( p != 0) {
                            for(int k = 0; k < n; k+= 2) {
                                t[k] = (char)('0' + (t[k] - '0' + a) % 10);
                            }
                        }
                        String temp = new String(t);
                        if(temp.compareTo(ans)<0) {
                            ans = temp;
                        }
                    }
                }
                String temp = new String(t);
                if(temp.compareTo(ans)<0) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
