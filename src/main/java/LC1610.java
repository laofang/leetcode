import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode1610题，可见点的最大数目
 * 关键字：几何、数组、数学、排序、滑动窗口
 * 主要思路：
 * 1. 以location为原点，将其他点转化为相对location和x轴正方向的角度
 * 2. 按角度大小，对这些点进行排序
 * 3. 以每个点为起始，偏转angle角度，在这个窗口间所有的点数量进行记录，然后移动窗口
 * 注意事项：
 * 1. 起始在第四象限，窗口右侧在第一象限时，是绕了一圈，可以复制数组list[i+n] = list[i] + 2*PI，或者根据模来计算
 * 2. 在location位置的点，可以开始计数，最后再加上
 * 3. 开始使用LinkedList会超时，改成ArrayList就好了，只查找ArrayList比LinkedList还是快很多
 * 新的知识：
 * 1. Math.atan2()方法
 * 2. Math.atan()方法
 */
public class LC1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int lX = location.get(0);
        int lY = location.get(1);
        List<Double> res = new ArrayList<>();
        int self = 0;
        //进行转换
        for(List<Integer> l : points) {
            int x = l.get(0);
            int y = l.get(1);
            //和location相等
            if(y - lY == 0 && x - lX == 0) {
                self++;
                continue;
            } else {
                //一二象限不用管
                double v = Math.atan2(y - lY, x - lX);
                if(y - lY >= 0){
                    res.add(v);
                    //三四象限 + 2 * PI
                } else {
                    res.add(v + Math.PI * 2);
                }
            }
        }
        //排序
        Collections.sort(res);
        int ans = 0;
        int j = 0;
        int n = res.size();
        //窗口移动记录更新
        for(int i = 0; i < res.size();i++) {
            double s = res.get(i); //窗口左侧
            double e = s  + Math.PI / 180 * angle;  //窗口右侧
            while(true) {
                //s在第四象限，e在第一象限
                if(j >= n) {
                    //相当于%n
                    int index = j - n;
                    //饶了一圈，那全部点都能看见了，直接返回points.size()即可
                    if( index == i) {
                        return points.size() ;
                    }
                    //
                    double value = res.get(index) + 2 * Math.PI;
                    if(value > e) {
                        break;
                    }
                    //除了四一象限的情况
                } else {
                    if(res.get(j) > e) {
                        break;
                    }
                }
                j++;
            }
            //每次更新记录
            ans = Math.max(ans,j - i  + self);
        }
        //如果除了自身，没有其他点
        ans = Math.max(ans,self);
        return ans;

    }
}
