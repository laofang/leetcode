/**
 * Leetcode838题，推多米诺
 * 关键字：动态规划、双指针、字符串
 * 主要思路：
 * 1. 使用双指针模拟推倒过程
 * 2. 左指针指向左侧将要推到的竖直那一块，右指针指向右侧将要推到那一块，左右中间是竖直的牌
 * 3. 根据左右推到的方向，对中间的进行处理，共有三种情况
 *      1. 左向右推，右向左推，两侧向中间变化
 *      2. 左向右推，右向右推（包括是右边缘的情况），都变'R'
 *      3. 左向左推（包括在左边缘的情况），右向左腿，都变'L'
 */
public class LC838 {
    public String pushDominoes(String dominoes) {
        int i = 0;
        char[] chars = dominoes.toCharArray();

        while(i < dominoes.length()) {
            if(dominoes.charAt(i) != '.') {
                i++;
                continue;
            }

            int left = i;
            int right = i + 1;
            while(right < dominoes.length() && dominoes.charAt(right) == '.') right++;
            i = right+1;
            //左侧向右，右侧向左
            if(left > 0 && dominoes.charAt(left-1) == 'R' && right < dominoes.length() && dominoes.charAt(right) == 'L') {
                right = right - 1;
                while(left < right) {
                    chars[left++] = 'R';
                    chars[right--] = 'L';
                }

            }
            //左侧向左，右侧向左
            else if( (left == 0 || chars[left-1] == 'L') && ( right < dominoes.length() && dominoes.charAt(right) == 'L')) {
                while(left < right) {
                    chars[left++] = 'L';
                }
            }
            //左侧向右，右测向右
            else if(( left > 0 && dominoes.charAt(left-1) == 'R') && (right == dominoes.length() || chars[right]== 'R')) {
                right = right - 1;
                while(left <= right) {
                    chars[right--] = 'R';
                }
            }

        }
        return new String(chars);
    }
}
