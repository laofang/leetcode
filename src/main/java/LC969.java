import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode969题，煎饼排序
 * 关键字：数组、排序
 * 主要思路：
 * 1. 遍历，每次选取最大的元素
 * 2. 最大的元素索引是0，那就整体反转一次，索引是当前循环的最后一个元素，不用反战，否则最大元素与第一个元素反转，然后整体反转
 */
public class LC969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new LinkedList();
        int maxVlaue = 0;
        int maxIndex = 0;
        //每次找到最大的，如果位置是0，则完全反转一次，如果是最后，不反转，否则都连续反转两次
        for(int i = 0; i < arr.length-1;i++) {
            maxVlaue=0;
            maxIndex=0;
            for(int j = 0; j < arr.length - i;j++) {
                if(arr[j] > maxVlaue) {
                    maxVlaue = arr[j];
                    maxIndex = j;
                }
            }
            if(maxIndex == arr.length-i - 1) continue;
            if(maxIndex == 0) {
                reverse(arr,arr.length-i-1);
                ans.add(arr.length-i);
            } else {
                ans.add(maxIndex+1);
                ans.add(arr.length-i);
                reverse(arr,maxIndex);
                reverse(arr,arr.length-i-1);
            }
        }
        return ans;
    }

    private void reverse(int[] arr,int index) {
        int l = 0;
        int r = index;
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
