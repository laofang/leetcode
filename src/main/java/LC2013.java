import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode2013题，检测正方形
 * 关键字：数组、哈希
 * 主要思路：
 * 1. add时，加入list和用map计数
 * 2. 查找时，先找到与给定点x相等的点
 * 3. 有这两个点，就可以构造出另外两个点，直接查找这两个点的数量，有一对可能
 * 4. 三个点的数量相乘就是一种可能的数量，累计
 */
public class LC2013 {
    Map<Integer,Integer> map;
    List<int[]> list;
    final int NUM = 10000;
    public LC2013() {
        map = new HashMap<>(5000);
        list = new ArrayList<>(5000);
    }

    public void add(int[] point) {
        int key = point[0] * NUM + point[1];
        int count = map.getOrDefault(key,0);
        if(count == 0) {
            list.add(point);
        }
        map.put(key,++count);
    }

    public int count(int[] point) {
        int ans = 0;
        for(int i = 0; i < list.size();i++) {
            int[] p = list.get(i);
            if(point[0] != p[0]) continue;

            int length = Math.abs(point[1] - p[1]);
            if(length == 0) continue;

//                int c0 = map.getOrDefault(point[0] * NUM + point[1],0) + 1;

            int c1 = map.getOrDefault(p[0] * NUM + p[1],0);

            int c21 = map.getOrDefault((point[0] + length) * NUM + point[1],0);
            int c31 = map.getOrDefault((point[0] + length) * NUM + p[1],0);


            int c22 = map.getOrDefault( (point[0] - length) * NUM + point[1],0);
            int c32 = map.getOrDefault( (point[0] - length) * NUM + p[1],0);



            ans += c1 * c21 * c31 + c1 * c22 * c32;

        }
        return ans;
    }
}
