import java.util.Arrays;

/**
 * LC5920题，分配给商店的最多商品的最小值
 * 给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 quantities[i] 表示第 i 种商品的数目。
 *
 * 你需要将 所有商品 分配到零售商店，并遵守这些规则：
 *
 * 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
 * 请你返回最小的可能的 x 。
 * 关键字：二分法
 * 主要思路：
 * 1. 用二分法尝试不同的值进行平均分配
 * 2. left = 1, right = 最大种类商品的数量
 * 3. 如果按mid平均分，看可以分给多少个商家，
 *      如果可分配商家数量>n，说明分的数量太小left = mid + 1
 *      如果可分配商家数量<=n，说明分的数量太大right = mid
 *      直到left == right为止
 */
public class LC5920 {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int left = 1;
        //最大数量的商品
        int right = quantities[quantities.length - 1];

        while(left < right) {
            int mid = (left + right) / 2;
            if(check(mid,quantities,n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int mid,int[] quantities,int n) {
        int cnt = 0;
        for(int i = 0; i < quantities.length; i++) {
            cnt += Math.ceil((float)quantities[i] / mid);
        }
        return cnt <= n;
    }
}
