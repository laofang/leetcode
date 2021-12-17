/**
 * Leetcode1518题，换酒问题
 * 关键字：数学、模拟
 * 主要思路：
 * 1. 模拟就好，按照  酒的数量，空瓶数量，换的酒的数量，和剩余空瓶，循环这个过程即可
 * ps:
 * 看到这道题，彷佛回到了初中。那是一年暑假，数学的作业卷子老师也没有答案，就提前叫了几个成绩较好的同学，来对一下答案。这道题就是当时的一道题，我也不知道为什么对这道题有如此深刻的印象，
 */
public class LC1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        //空瓶
        int emptyBottles = 0;
        //酒瓶不为0
        while(numBottles != 0) {
            //咕嘟咕嘟
            ans += numBottles;
            //喝过之后，酒瓶变空瓶,再加上上次换的剩下的空瓶
            emptyBottles += numBottles;
            //空瓶换酒瓶
            numBottles = emptyBottles / numExchange;
            //换不了剩下的空瓶
            emptyBottles = emptyBottles % numExchange;
        }
        return ans;
    }
}
