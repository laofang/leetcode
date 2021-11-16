import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode391题，完美矩形
 * 关键字：扫描线、图形、矩形、哈希
 * 主要思路：
 * 1. 扫描线算法，从左向右扫描每一条边
 * 2. 如果是一个完美矩形，一定会有以下的性质
 *      1. 如果边是边缘的边，那么构成这条边的线段一定要恰好首尾相连
 *      2. 如果边是非边缘的边，可能不连续（但一定不相交），构成这个边的左侧和右侧线段一定是成对出现
 *      满足这两点的图形就是完美矩形
 */
public class LC391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] segment = new int[n * 2][4];
        //转化成垂直方向的线段[x,y1,y2,flag] x横坐标，y1线段下端纵坐标，y2线段上端纵坐标，flag标识是矩形的左侧边还是右侧边
        for (int i = 0; i < rectangles.length; i++) {
            //每个据矩形左右有两条边
            segment[i * 2] = new int[]{rectangles[i][0], rectangles[i][1], rectangles[i][3], -1};
            segment[i * 2 + 1] = new int[]{rectangles[i][2], rectangles[i][1], rectangles[i][3], 1};
        }
        //按x,y1排序
        Arrays.sort(segment, (e1, e2) -> e1[0] != e2[0] ? e1[0] - e2[0] : e1[1] - e2[1]);
        //lList存当前x的左侧边，rList存当前x的右侧边
        List<int[]> lList = new LinkedList<>(), rList = new LinkedList<>();
        //判断相同x位置的线段，如果是边缘，要能收尾相接，如果是非边缘不相交，且左右要成对出现
        for (int l = 0; l < segment.length; ) {
            int r = l;
            //[l,r)区间的都是x横坐标相等的
            while (r < segment.length && segment[r][0] == segment[l][0]) r++;
            lList.clear();
            rList.clear();
            //遍历[l,r)区间
            for (int i = l; i < r; i++) {
                //看是哪一侧的边，就用哪里list来处理或存储
                List<int[]> list = segment[i][3] == -1 ? lList : rList;
                //当前线段因为循环内x都相同，不用再存了
                int[] cur = new int[]{segment[i][1], segment[i][2]};
                //list有元素
                if (list.size() > 0) {
                    //最后一个元素
                    int[] pre = list.get(list.size() - 1);
                    //线段相交，返回false;
                    if (pre[1] > cur[0]) {
                        return false;
                        //前一个末尾和当前的头一样，进行连接
                    } else if (pre[1] == cur[0]) {
                        pre[1] = cur[1];
                        //不相连加入即可
                    } else {
                        list.add(cur);
                    }
                    //list没有元素，直接加入
                } else {
                    list.add(cur);
                }
            }
            //非边缘边
            if (l > 0 && r < segment.length) {
                //l与r成对出现，那么两个list的size是相等的
                if (lList.size() == rList.size()) {
                    //比较每一个线段，如果不相等则返回false;
                    for (int j = 0; j < lList.size(); j++) {
                        //每一个线段的对应端点y坐标是否相等
                        if (lList.get(j)[0] != rList.get(j)[0] || lList.get(j)[1] != rList.get(j)[1]) {
                            return false;
                        }
                    }
                    //左右两侧线段数不一致，则返回false;
                } else {
                    return false;
                }
                //无论左右的边缘边，都一定是连续的一条边
            } else {
                if (lList.size() + rList.size() != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
