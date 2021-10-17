/**
 * Leetcode5886，竞赛题，如果相邻两个颜色均相同则删除当前颜色
 * 主要思路：
 * 1。 只要算出两人各有多少次操作的机会，由于Alice先手，所以Bob的操作次数>=Alice操作数即赢，相反Alice胜利
 * 2. 如果有两个连续，如果接下来还连续，每有一个连续，则增加一次机会
 * 3. 统计两人的操作机会，对比数量结果即可
 *
 */
public class LC5886 {
    public boolean winnerOfGame(String colors) {
        //连续数量
        int aCount = 0;
        int bCount = 0;
        //累计机会
        int aChance = 0;
        int bChance = 0;
        for(int i = 0; i < colors.length(); i++) {
            if(colors.charAt(i) == 'A') {
                //一旦字母是A,B的连续重计
                bCount = 0;
                //A的连续相加
                aCount++;
                //如果大于等于3，即获得一次机会
                if( aCount >= 3) {
                    aChance++;
                }
            }
            if(colors.charAt(i) == 'B') {
                aCount = 0;
                bCount++;
                if(bCount >= 3) {
                    bChance++;
                }
            }
        }
        return bChance >= aChance ? false:true;
    }
}
