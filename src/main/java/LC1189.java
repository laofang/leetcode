/**
 * Leetcode1189题，“气球”的最大数量
 * 关键字：统计、数组、哈希、字符串
 * 主要思路：
 * 1. 统计“气球”每个字母出现的次数
 * 2. 其中，出现次数最少的字母的次数就是答案（注意'l'和'o'出现了两次）
 */
class LC1189 {
    public int maxNumberOfBalloons(String text) {
        int[] nums = new int[5];
        for (int i = 0; i < text.length(); i++) {
            int index = getIndex(text.charAt(i));
            if(index == -1) continue;
            nums[index]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans,i == 2 || i == 3 ? nums[i] / 2 : nums[i]);
        }
        return ans;
    }

    private int getIndex(char ch) {
        int index = -1;
        switch (ch) {
            case 'b':
                index = 0;
                break;
            case 'a':
                index = 1;
                break;
            case 'l':
                index = 2;
                break;
            case 'o':
                index = 3;
                break;
            case 'n':
                index = 4;
                break;
            default:
                index = -1;
        }
        return index;
    }
}