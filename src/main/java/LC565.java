/**
 * Leetcode565题，数组嵌套
 * 关键字：深度优先搜索、数组
 * 主要思路：
 * 1. 模拟即可
 * 2. 从第一个元素开始，直到遍历到环的位置，看长度是否更新
 * 3. 选择下一个元素，被选过的元素不能再被选择
 */
public class LC565 {
    int[] used;
    int ans = 0;
    public int arrayNesting(int[] nums) {

        used = new int[nums.length];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            int cnt = 0;
            while(used[cur] != 1) {
                c++;
                cnt++;
                used[cur] = 1;
                cur = nums[cur];
                ans = Math.max(ans,cnt);
            }
            if(c == nums.length) break;
        }
        return ans;
    }
}
