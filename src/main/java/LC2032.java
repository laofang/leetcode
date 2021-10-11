import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode2032,至少在两个数组出现的值
 * 关键字：hashset
 * 主要思路：
 * 1. 将第一数组放入hashmap,第二数组边查边入map，如果重复，则是一个目标值，第三数组只查即可
 * 2. 时间复杂度O(n)
 *
 */
public class LC2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        //使用hashset存结果去重
        HashSet<Integer> hs = new HashSet<Integer>();
        //将第一个数组元素放入map
        for(int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i],1);
        }
        //判断第二个元素是否在hash出现，且值是1，并放入第二个数组
        for(int i = 0; i < nums2.length; i++) {
            Integer index = hm.get(nums2[i]);
            if(index == null) {
                hm.put(nums2[i],2);
            } else if(index !=2){
                hs.add(nums2[i]);

            }
        }
        //查看第三个数组元素在map中是否存在
        for(int i = 0; i < nums3.length; i++) {
            Integer index = hm.get(nums3[i]);
            if(index != null) {
                hs.add(nums3[i]);
            }
        }
        int[] res = new int[hs.size()];
        LinkedList<Integer> resL = new LinkedList<Integer>();
        resL.addAll(hs);
        return resL;
    }
}
