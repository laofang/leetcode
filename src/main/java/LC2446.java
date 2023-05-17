/**
 * Leetcode2446题，判断两个事件是否存在冲突
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 算出每个时间相对于00:00的偏移分钟数，再根据条件判断之间的关系
 *
 */
public class LC2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = transfer(event1[0]);
        int end1 = transfer(event1[1]);
        int start2 = transfer(event2[0]);
        int end2 = transfer(event2[1]);
        if(start1 >= start2 && start1 <= end2)
            return true;
        if(end1 >= start2 && end1 <= end2)
            return true;
        if(start2 >= start1 && start2 <= end1)
            return true;
        if(end2 >= start1 && end2 <= end1)
            return true;
        return false;
    }
    public int transfer(String time) {
        String[] times = time.split(":");
        int intTime = Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
        return intTime;
    }
}
