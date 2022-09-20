import java.util.Arrays;

/**
 * Leetcode698题，划分k个相等的子集
 * 关键字：位运算、记忆化搜索、数组、动态规划、回溯、状态压缩
 * 主要思路：
 * 1. 采用回溯算法
 * 2. 遍历数字，按顺序填满每一个桶，如果当前数字大，就选择下一个数字，如果桶无法用存在的数字填入，则进行回溯
 * 3. 注意这里是以桶为主，尝试每个数字填入桶内，另一种做法是以数字为主，尝试每个桶，放入可放入的桶
 * 4. 这里注意要剪枝，否则会超时
 */
public class LC698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum / k * k != sum) return false;
        int capacity = sum / k;
        int[] table = new int[k];
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        return traceBack(flag,table,nums,0,0,0,capacity);
    }

    public boolean traceBack(int[] flag, int [] table,int[] nums,int numIndex,int curTab,int putCnt, int capacity) {
        if(putCnt == nums.length) {
            return true;
        }
        for(int i = numIndex; i < nums.length; i++) {
            if(flag[i] == 1) continue;
            if(table[curTab] + nums[i] > capacity) continue;
            table[curTab] += nums[i];
            flag[i] = 1;
            ++putCnt;


            boolean ret;
            ret = traceBack(flag,table,nums,table[curTab] == capacity ? 0 :numIndex + 1,table[curTab] == capacity ?curTab + 1 : curTab,putCnt,capacity);
            if(ret) return ret;
            table[curTab] -= nums[i];
            --putCnt;
            flag[i] = 0;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
        return false;
    }
    //todo Leetcode698题，划分k个相等的子集，回溯、状态压缩，虽然过了但是效率不高，还有剪枝优化的空间
}
