/**
 * Leetcode2383题，赢得比赛需要的最少训练时长
 * 关键字：贪心、数组
 * 主要思路：
 * 1. 锻炼后的能量要比所有敌人的能量和多1
 * 2. 锻炼后的经验，要保证在面对下一个敌人时，达到敌人的经验 - 前面所有获得的经验 + 1
 * 3. 最后计算训练时长，要注意最后需要的能量和经验与初始给定的能量经验的大小关系
 */
public class LC2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainEnergy = 0;
        int trainExperience = 0;
        int expSum = 0;
        for(int i = 0; i < energy.length; i++) {
            trainEnergy += energy[i];
            trainExperience = Math.max(trainExperience,experience[i] - expSum + 1);
            expSum += experience[i];
        }
        trainEnergy++;
        return (trainEnergy > initialEnergy ? trainEnergy - initialEnergy : 0) +
                (trainExperience > initialExperience ? trainExperience - initialExperience : 0);
    }
}
