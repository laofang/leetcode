import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Leetcode519题，随机翻转矩阵
 * 关键字：矩阵、随机、哈希、水塘抽样
 * 主要思路：
 * 1. 开始用数组洗牌算法，而且进行了优化，但是当m、n=10000时，内存溢出
 * 2. 之后用了Map，和洗牌算法类似，每次从0~k之间随机，然后将最后一个的值，给随机到的键
 */
public class LC519 {
    private Map<Integer,Integer> map;
    private int total;
    Random random;
    int m = 0;
    int n = 0;
    public LC519(int m, int n) {
        total = m * n;
        map = new HashMap<Integer,Integer>();
        random = new Random();
        this.n = n;
        this.m = m;
    }

    public int[] flip() {
        int x = random.nextInt(total);
        total--;
        int ans = map.getOrDefault(x,x);
        map.put(x,map.getOrDefault(total,total));
        return new int[]{ans / n,ans % n};
    }

    public void reset() {
        map.clear();
        total = m * n;
    }
}
