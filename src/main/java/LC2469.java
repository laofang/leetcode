/**
 * Leetcode2469题，温度转换
 * 关键字：数学
 * 主要思路：
 * 1. 这可能时最简单的一道题了
 */
public class LC2469 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15,celsius * 1.8 + 32.0};
    }
}
