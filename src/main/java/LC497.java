import java.util.Random;

/**
 * Leetcode497题，非重叠矩形中的随机点
 * 关键字：水塘抽样、数学、二分查找、有序集合、前缀和、随机化
 * 主要思路：
 * 1. 所有矩形上的整数点，要等概率抽取
 * 2. 按矩形顺序，将每个矩形整数点的数量相加
 * 3. 从所有点的索引中，抽出一个
 * 4. 用二分法定位该点所属的矩形
 * 5. 再根据抽取点在所属矩形的相对位置，返回点的坐标
 */
public class LC497 {
    private int[][] rects;
    private int[] pointCount;
    public LC497(int[][] rects) {
        this.rects = rects;
        pointCount = new int[rects.length];
        int pre = 0;
        for(int i = 0; i < rects.length; i++) {
            pointCount[i] = pre + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            pre = pointCount[i];
        }
    }

    public int[] pick() {
        Random random = new Random();
        int index = random.nextInt(pointCount[pointCount.length-1]) + 1;
        int l = 0;
        int r = pointCount.length - 1;
        while(l <= r) {
            int half = (l + r) / 2;
            if(pointCount[half] >= index) {
                r = half - 1;
            } else {
                l = half + 1;
            }
        }

        index = l == 0 ? index : index - pointCount[l - 1];

        int m = rects[l][2] - rects[l][0] + 1;
        int x = rects[l][0] + (index-1) % m;
        int y = rects[l][1] + (index-1) / m;
        return new int[]{x,y};
    }
}
