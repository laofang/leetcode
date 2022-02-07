/**
 * Leetcode1405题，最长快乐字符串
 * 关键字：字符串、优先队列
 * 主要思路：
 * 1. 三个里面选最多的，如果符合要求就放入，
 * 2. 不符合要求就放入数量次多的字母
 */
public class LC1405 {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder ans = new StringBuilder();

        int[] array = new int[3];
        array[0] = a;
        array[1] = b;
        array[2] = c;

        char[] dic = new char[3];
        dic[0] = 'a';
        dic[1] = 'b';
        dic[2] = 'c';

        int index1 = 0;
        int index2 = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > count) {
                index2 = index1;
                index1 = i;
                count = array[i];
            }
        }

        while(array[index1] > 0) {
            int len = ans.length();
            if(len >= 2 && ans.charAt(len-2) == dic[index1] && ans.charAt(len-1) == dic[index1]) {
                if(index2 == -1 || array[index2] == 0) break;
                array[index2]--;
                ans.append(dic[index2]);
            } else {
                array[index1]--;
                ans.append(dic[index1]);
            }

            count = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] > count) {
                    index1 = i;
                    count = array[i];
                }
            }
            if(array[(index1+1)%3] >= array[(index1+2) % 3]) {
                index2 = (index1 + 1) % 3;
            } else {
                index2 = (index1 + 2) % 3;
            }
        }
        return ans.toString();
    }
}
