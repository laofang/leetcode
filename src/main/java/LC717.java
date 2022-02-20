/**
 * Leetcode717题，1比特与2比特字符
 * 关键字：数组
 * 主要思路：
 * 如果是1开头，向后跳两次，如果0开头向后跳一次
 * 如果指针可以在最后一个元素上，说明最后一个元素是0，否则不是1bit字符
 */
public class LC717 {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i < bits.length; i++) {
            if(i == bits.length - 1) return true;
            i = bits[i] == 1 ? i + 1 : i;
        }
        return false;
    }
}
