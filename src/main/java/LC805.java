import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode805题，数组的均值分割
 * 关键字：位运算、数组、数学、动态规划、状态压缩
 * 主要思路：
 * 1. 可以看作，是否能在nums中找到一个子集，这个子集的平均数和nums的平均数相等，此时这个子集的补集的平均数也和nums的平均数相等
 * 2. 如果直接枚举所有情况，那时间复杂度大概在2^n会超时
 * 3. 将nums分为两部分进行枚举，第一部分在枚举的过程中，结果进行缓存(选择的元素和，选择元素数量），然后再枚举后半部分，然后遍历，看是否存在一个缓存，使前后选择的和除以，选择的总数量，平均值和sum/n相等
 */
public class LC805 {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        //n如果是奇数 m + 1 = (n - m)
        int m = n / 2;
        int total = 0;
        for(int num : nums) total += num;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //从数组的前半部分进行枚举，state的m位中，对应1的位置，就是选中的nums的元素，状态压缩
        for(int state = 0; state < (1 << m); state++) {
            //map的key是每种选择的对应的和，cnt是选择的元素数量
            int sum = 0;
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                //如果对应的元素被选择，选择的元素和 和元素数目都要累计
                if(((state >> i) & 1) == 1) {
                    sum += nums[i];
                    cnt++;
                }
            }
            //存储选择的元素和，和选择的元素数量
            Set<Integer> set = map.getOrDefault(sum,new HashSet<>());
            set.add(cnt);
            map.put(sum,set);
        }
        //从数组的后半部分进行枚举，state的(n-m)位中，和上面类似
        for(int state = 0; state < (1 << (n - m)); state++) {
            int sum = 0;
            int cnt = 0;
            for(int i = 0; i < (n - m); i++) {
                if(((state >> i) & 1) == 1) {
                    //这里要从m开始
                    sum += nums[m + i];
                    cnt++;
                }
            }
            //k是一共选择k个数，如果k个数的平均数 = sum / n，那么未选择的k个数的平均数也是 sum / n
            for(int k = cnt >= 1 ? cnt : 1; k < n; k++) {
                //k个数的和应该是整数，所以 k * total / n 一定要是整数才行
                if(k * total % n != 0) continue;
                //选出的k个数的和
                int kSum = k * total / n;
                //已知nums后半部分选出了cnt个元素，cnt个元素和为sum，然后来看前半部分的和为kSum - sum,数量为k - cnt是否存在
                if(map.get(kSum - sum) == null) continue;
                if(!map.get(kSum - sum).contains(k - cnt)) continue;
                return true;
            }
        }
        return false;
    }
}
