/**
 * Leetcode2409题，统计共同度过的日子数
 * 关键字：数学、字符串
 * 主要思路：
 * 1. 把日期转换为该日期距离第一天的天数，在进行多种情况的判断和计算
 */
public class LC2409 {
    final int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa = getDays(arriveAlice);
        int al = getDays(leaveAlice);
        int ba = getDays(arriveBob);
        int bl = getDays(leaveBob);
        if(al < ba || bl < aa) return 0;
        if(aa <= ba && bl <= al) {
            return bl - ba + 1;
        } else if( ba <= aa && al <= bl) {
            return al - aa + 1;
        } else if( aa <= ba && al <= bl) {
            return  al - ba + 1;
        } else  {
            return bl - aa + 1;
        }
    }
    public int getDays(String day) {
        String[] strs = day.split("-");
        int month = Integer.valueOf(strs[0]);
        int dayInt = Integer.valueOf(strs[1]);
        int result = 0;
        for(int i = 0; i < month - 1; i++) {
            result += days[i];
        }
        return result + dayInt;
    }
}
