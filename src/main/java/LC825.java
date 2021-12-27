import java.util.Arrays;

/**
 * Leetcode825题，适龄的朋友
 * 关键字：数组、双指针
 * 主要思路：
 * 1. 根据三个条件，可以得出，每个人会给小于等于自己年龄，且大于自己年龄*0.5+7的人发信息
 * 2. 最后一个条件没有用，第二个条件已经包含
 * 3. 将年龄进行排序，遍历每个人，能够发消息的人是一个范围，范围是 (ages[x] * 0.5 + 7,ages[x]](左开右闭)
 * 4. 下一个人，左右指针向右移动到新的合适的位置即可
 *
 */
public class LC825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int l = 0;
        int r = 0;
        //遍历每一个人
        for(int i = 0; i < ages.length;i++) {
            //右边界确定
            while(r < ages.length && ages[r] <= ages[i]) {
                r++;
            }
            //左边界确定
            while(l < r && ages[l] <= ages[i] * 0.5 + 7) {
                l++;
            }
//            System.out.println(r + " " + l + " " + (ages[i] * 0.5 + 7));
            //窗口中的人数
            if(l != r) {
                ans += (r - l) - 1;
            }
        }
        return ans;
    }
}
