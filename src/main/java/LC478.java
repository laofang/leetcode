/**
 * Leetcode478题，在圆内随机生成点
 * 关键字：几何、数学、拒绝采样、随机化
 * 主要思路：
 * 1. 按直径范围来随机取点
 * 2. 如果范围在圆之外，则重新取点，这是拒绝采样的方法
 */
public class LC478 {
    private double radius;
    private double x_center;
    private double y_center;
    private double xMin;
    private double yMin;
    private double diameter;
    public LC478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        xMin = x_center - radius;
        yMin = y_center - radius;
        diameter = 2 * radius;
    }

    public double[] randPoint() {
        while(true) {
            double x = Math.random()* diameter + xMin;
            double y = Math.random()* diameter + yMin;
            if((x - x_center) * (x - x_center) + (y - y_center) * (y - y_center) <= radius *radius){
                return new double[]{x,y};
            }
        }
    }
}
