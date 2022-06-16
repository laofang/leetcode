import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Leetcode532题，数组中的k-diff数对
 * 关键字：数组、哈希表、双指针、排序、二分查找
 * 主要思路：
 * 1. 先排序，然后遍历，用队列保存需要查找的数字nums[i] + k
 * 2. 当前大于队头的就出队，如果等于ans++
 * 又想到了先排序，再双指针的做法，也比较简单
 */
public class LC532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length;i++) {
            if(!queue.isEmpty()) {
                while(!queue.isEmpty() && nums[i] > queue.peek()){
                    queue.pop();
                }

                if(!queue.isEmpty() && nums[i] == queue.peek() && !set.contains(nums[i])) {
                    ans++;
                    set.add(nums[i]);
                }

                queue.offer(nums[i]+k);

            } else {
                queue.offer(nums[i] + k);
            }
        }
        return ans;
    }

    /**
     * 双指针做法
     * @param nums
     * @param k
     * @return
     */
    public int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1;
        int ans = 0;
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            if (i >= j) j = i + 1;
            if (j == nums.length) break;
            int target = nums[i] + k;
            if (nums[j] > target) continue;

            while (j < nums.length && nums[j] < target) j++;
            if (j == nums.length) break;

            if (nums[j] == target) ans++;
            while (j < nums.length && nums[j] == target) j++;

        }
        return ans;
    }
}
