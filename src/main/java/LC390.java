/**
 * Leetcode390题，消除游戏
 * 关键字：数学
 * 主要思路；
 * 1. f[i] + f'[i] = i + 1
 * 2. f[i] = 2 * f'[i/2]
 * 3. f[i] = 2 * ( i/2 + 1 - f[i/2])
 */
public class LC390 {
    public int lastRemaining(int n) {
        if(n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

}

//todo LC390题，消除游戏，类约瑟夫环的问题，公式还要再深入理解一下