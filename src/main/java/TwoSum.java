import java.util.HashMap;

/**
 * 第一印象的算法，时间复杂度是2n
 * 看过参考答案后，知道可以在n的时间复杂度解决该问题，同时也减少了内存的开销
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numToIndexMap = new HashMap();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            numToIndexMap.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
            Integer res = target - nums[i];
            Integer resIndex = numToIndexMap.get(res);
            if(resIndex != null && resIndex != i) {
                result[0] = i;
                result[1] = numToIndexMap.get(res);
                break;
            }
        }
        return result;
    }


}
