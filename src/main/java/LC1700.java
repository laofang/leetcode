/**
 * Leetcode1700题，无法吃午餐的学生数量
 * 关键字：栈、队列、数组、模拟
 * 主要思路：
 * 1. 学生是可以循环的，所以记录吃圆形三明治数量的学生，和吃方形三明治的学生
 * 2. 如果当前的三明治，没有学生想吃，则结束，剩余的学生就是无法吃午餐的学生
 */
public class LC1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < students.length; i++) {
            if(students[i] == 1) ++cnt1;
            else ++cnt2;
        }
        int j = 0;
        for(; j < sandwiches.length; j++) {
            if(sandwiches[j] == 1) {
                if(cnt1 == 0) break;
                --cnt1;
            } else {
                if(cnt2 == 0) break;
                --cnt2;
            }
        }
        return sandwiches.length - j;
    }
}
