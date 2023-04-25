/**
 * Leetcode2418题，按身高排序
 * 关键字：数组、哈希表、字符串、排序
 * 主要思路：
 * 1. 对heights进行插入排序，同时对names进行对应的排序
 */
public class LC2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i = 1; i < heights.length; i++) {
            int j = i - 1;
            int cur = heights[i];
            String name = names[i];
            while(j >= 0 && heights[j] < cur) {
                heights[j+1] = heights[j];
                names[j+1] = names[j];
                j--;
            }
            heights[j+1] = cur;
            names[j+1] = name;
        }
        return names;
    }
}
