import java.util.*;

/**
 * Leetcode448题，祖玛游戏
 * 关键字：DFS、BFS
 * 主要思路：
 * 1. 这题做的很艰难，主要用BFS来做的
 * 2. 首先，board和hand的不同组合都是潜在的答案
 * 3. 将hand中的每一个元素，插入到board的每一个位置
 *      1. 新生成的board要递归删除连续三个或及其以上的子串
 *         1. 如果新生成的board是空字符串，说明消除成功，根据newHand剩余的字符数量，可以直到用了几个球
 *      2. 最后产生newBoard{newBoard,newHand}就是一种新的组合，加入到队列
 * 优化：
 * 1. 将hand排序，如哦当前的字符和之前的相同，就没必要再尝试
 * 2. 每次组合都存到map中，如果一个新的组合已经出现过，就不用再尝试了
 */
public class LC488 {
    public int findMinStep(String board, String hand) {

        int length = hand.length();
        //给hand排序
        char[] chs = hand.toCharArray();
        Arrays.sort(chs);
        hand = new String(chs);
        //board和hand组合队列
        Queue<String[]> queue = new LinkedList<>();
        //初始组合就是board和hand
        queue.offer(new String[]{board,hand});
        //出现过的记录
        Map<String,String> map = new HashMap<>();
        map.put(board,hand);



        while(!queue.isEmpty()) {
            //从队列里拿出每一个组合
            String[] compose = queue.poll();
            //拿出hand里的每一个放入board的每一个位置，如果新生成的board不为空字符串则和剩余的hand作为一个新的组合入队
            for(int i = 0; i < compose[1].length();i++) {
                //剪枝，如果当前的和前一个一样就不用尝试了
                if(i > 0 && compose[1].charAt(i) == compose[1].charAt(i-1)) {
                    continue;
                }
                for(int j = 0; j <= compose[0].length();j++) {

                    StringBuilder tBoard = new StringBuilder(compose[0]);
                    StringBuilder tHand = new StringBuilder(compose[1]);
                    //将hand[i]插入到board的每一个位置
                    tBoard.insert(j,tHand.charAt(i));
                    tHand.deleteCharAt(i);
                    //删除>=3的连续字符
                    String nBoard = removeSame(tBoard.toString());
                    //删除后为0，说明成功消除了，返回结果
                    if(nBoard.length() == 0) {
                        return length - tHand.length();
                    }

                    //剪枝，如果这种组合已经加入过队列，就不用再试了
                    String value = map.get(nBoard);
                    if(value != null && value.equals(tHand.toString())) {
                        continue;
                    } else {
                        //队列加入新的组合
                        queue.offer(new String[]{nBoard,tHand.toString()});
                        //加入记录
                        map.put(nBoard,tHand.toString());
                    }
                }
            }
        }
        return -1;

    }

    //删除连续大于等于3的子字符串
    public String removeSame(String board) {
        int startIndex = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder(board);
        for (int i = 1; i < sb.length(); i++) {
            //如果当前和前一个相等
            if(sb.charAt(i) == sb.charAt(i-1)) {
                //之前不相等，说明是第一次相等，记录这个位置
                if(!flag) {
                    startIndex = i - 1;
                    flag = true;
                }
            } else {
                //当不同的时候，可以删除
                if(i - startIndex >= 3) {
                    sb.delete(startIndex,i);
                    //删除之后，i的位置要重新定位，即是startIndex位置（再循环会自动+1）
                    i = startIndex;
                } else {
                    //不删除的情况，startIndex更新为i
                    startIndex = i ;
                }
                //说明这次开始，当前和前一个不同
                flag = false;
            }
        }
        //最后有连续相同字符串的情况，要额外处理一下
        if(sb.length() - startIndex >= 3) {
            sb.delete(startIndex,sb.length());
        }
        //如果没有可删除的，返回即可，否则就继续递归处理
        return sb.length() == board.length() ? board : removeSame(sb.toString());
    }
}
