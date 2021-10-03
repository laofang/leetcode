import java.util.HashMap;

/**
 * 两数之和
 */
public class TwoSum {
    /**
     * 第一印象的算法，时间复杂度是2n
     * 将问题中的数组转化成Map<value,index>
     * 遍历问题数组每一个元素nums[i]，测试Map中师傅存在一个(target - nums[i])的key
     * 若存在且对应的Index不等于当前的元素本身(i)，则i与对应的index即是该问题的解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            numToIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer res = target - nums[i];
            Integer resIndex = numToIndexMap.get(res);
            if (resIndex != null && resIndex != i) {
                result[0] = i;
                result[1] = numToIndexMap.get(res);
                break;
            }
        }
        return result;
    }

    /**
     * 看过解析后，改进的算法
     * 相较之前的算法，时间复杂度和空间复杂度都有所降低
     * 每次检查的是当前的元素和之前的某个元素是否能够组成解集
     * 每次检查后，将当前元素和索引加入Map中
     * @param nums
     * @param target
     * @return
     */
    public int[] improveTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = valueIndexMap.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            valueIndexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
