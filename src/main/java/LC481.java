/**
 * Leetcode481题，神奇字符串
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. 按照给定的规律，进行生成，边生成边统计
 * 2. 规律就是从'122'开始，当前字符的数字，代表生成字符的数量，生成什么字符要和上次生成的相反
 */
public class LC481 {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int i = 2;
        int flag = 2;
        int cnt = 1;
        int len = 3;
        while(len < n) {
            int time = sb.charAt(i) - 48;
            if(flag == 2) {
                sb.append('1');
                ++cnt;
                ++len;
                if(len == n) break;
                if(time == 2) {
                    sb.append('1');
                    ++len;
                    ++cnt;
                }
                flag = 1;
            } else {
                sb.append('2');
                ++len;
                if(len == n) break;
                if(time == 2) {
                    sb.append('2');
                    ++len;
                }
                flag = 2;
            }
            ++i;
        }
        return cnt;
    }
}
