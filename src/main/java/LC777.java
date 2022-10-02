/**
 * Leetcode777题，在LR字符串中交换相邻字符
 * 关键字：双指针、字符串
 * 主要思路：
 * 1. L可以在左侧有X的时候向前移动，R可以在右侧有X的时候向右移动
 * 2. 如果start可以转换成end，那么非X字符的相对顺序是相同的，同时有两个限制
 *      1. start的L的位置，不能在end对应L的位置的左侧，因为L只能左移
 *      2. 同理，start的R的位置，不能在end对应R的位置的右侧
 */
public class LC777 {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        while(i < start.length() && j < end.length()) {
            //start中下一个非'X'字符
            while(i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            //end中下一个非'X'字符
            while(j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if(i == start.length() || j == end.length()) break;
            char ch = start.charAt(i);
            if((start.charAt(i)) != end.charAt(j)) return false;
            if(ch == 'L' && i < j) return false;
            if(ch == 'R' && i > j) return false;
            i++;
            j++;
        }
        //如果其中一个遍历完成，另一个字符串的剩余字符中存在非'X'字符，说明未完全匹配
        while(i < start.length()) {
            if(start.charAt(i++) != 'X') return false;
        }
        while(j < end.length()) {
            if(end.charAt(j++) != 'X') return false;
        }
        return true;
    }
}
