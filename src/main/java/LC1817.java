import java.util.Arrays;

/**
 * Leetcode1817题，查找用户活跃分钟数
 * 关键字：数组、哈希表
 * 主要思路：
 * 1. 排序，分组统计
 * 2. 将logs[i][0]相同的，logs[i][1]去重后的logs[i]的长度为k，此时++ans[k]
 */
public class LC1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Arrays.sort(logs,(e1, e2)-> {
            if(e1[0] != e2[0]) return e1[0] - e2[0];
            return e1[1] - e2[1];
        });
        int cnt = 0;
        for(int i = 0;i < logs.length; i++) {
            if(i == 0) {
                cnt = 1;
            } else if(logs[i][0] != logs[i-1][0]) {
                ++ans[cnt-1];
                cnt = 1;
            } else {
                if(logs[i][1] != logs[i-1][1]) {
                    ++cnt;
                }
            }
        }
        ++ans[cnt-1];
        return ans;
    }
}
