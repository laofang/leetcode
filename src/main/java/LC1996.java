import java.util.Arrays;

/**
 * Leetcode1996题，游戏中弱角色的数量
 * 关键字：栈、贪心、数组、排序、单调
 * 主要思路：
 * 1. 按攻击力从大到小排序，攻击力相同时，按防御力从小到达排序
 * 2. 按这样的顺序遍历，避免了当前元素之前存在攻击力相同，防御力大于当前的情况
 * 3. 再进行遍历，如果当前元素的防御力，小于已遍历过的最大防御力，当前角色必然是弱角色
 */
public class LC1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        int maxDef = 0;
        int ans = 0;
        //按攻击力从大到小排序，攻击力相同时，按防御力从小到达排序
        //按这样的顺序遍历，避免了当前元素之前存在攻击力相同，防御力大于当前的情况
        Arrays.sort(properties,(e1, e2)->{
            if(e1[0] != e2[0]) {
                return e2[0] - e1[0];
            }
            return e1[1] - e2[1];
        });
        //遍历，只要防御力严格小于，那就一定是弱角色
        for (int i = 0; i < properties.length; i++) {
            if(properties[i][1] < maxDef) {
                ans++;
            }
            maxDef = Math.max(maxDef,properties[i][1]);
        }
        return ans;
    }
}
