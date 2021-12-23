/**
 * leetcode686题，重复叠加字符串匹配
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 至少要复制到>=b的大小的次数才可以，设这个最小次数是n
 * 2. 最多复制的次数就是n+1
 */
public class LC686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        while (sb.length() < b.length() ) {
            sb.append(a);
            ans++;
        }
        sb.append(a);
        int index = sb.indexOf(b);
        if (index == -1) {
            return -1;
        } else {
            if(a.length() * ans < index + b.length()) {
                return ans+1;
            } else {
                return ans;
            }
        }
    }
    //TODO 686题，重复叠加字符串匹配，KMP算法、sunday算法、BM算法需要好好看一下
}