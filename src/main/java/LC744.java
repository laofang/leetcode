/**
 * Leetcode744题，寻找比目标字母大的最小字母
 * 关键字：数组、二分法
 * 主要思路：
 * 1. 因为字符数组有序，所以可以使用二分法
 * 2. 二分法是选择比目标值大的最小值
 *      1. 当前half > target，right向half的左侧一个位置，这样循环下去，right会在<=target的最大位置
 *      2. 当前half <= target，left向half的右侧移动一个位置，循环下去，left会在停在 > target的最小位置
 */
public class LC744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while(l <= r) {
            int half = (l + r) / 2;
            if(letters[half] <= target) {
                l = half + 1;
            } else if(letters[half] > target) {
                r = half - 1;
            }
        }
        //如果l越界，说明不存在 > target的字母
        return l == letters.length ? letters[0] : letters[l];
    }
}
