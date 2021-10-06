/**
 * 字符串转换整数
 * 注意事项：
 * 1。要求的前提条件
 * 2. 边界判断
 */
public class LC8 {
    //根据反馈的错误信息，逐渐迭代而成，很不优雅
    public int myAtoi(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        Boolean plus = null;
        int rev = 0;
        //边界条件
        int MAX_INT = (int)Math.pow(2,31) ;
        int MIN_INT = - (int)Math.pow(2,31)  - 1;
        for (int i = 0; i < chars.length; i++) {
            //第一个字符是符号，且没记录过符号，才可以记录
            if(chars[i] == '-' && plus == null && i == 0) {
                plus = new Boolean(false);
            }
            else if(chars[i] == '+' && plus == null && i == 0){
                plus = new Boolean(true);
            }
            //如果是数字，进行处理拼接
            else if(chars[i] >= '0' && chars[i] <= '9') {
                //如果是正数，前面的数字大于MAX_INT/10 或者 等于MAX_INT/10 且 下一位大于等于7则过界
                if((plus == null || plus == true) && (rev > MAX_INT / 10 || rev == MAX_INT / 10 && chars[i] - '0' >=7) ) {
                    return MAX_INT;
                }
                //与上面类似
                else if(-rev < MIN_INT / 10 || (-rev == MIN_INT / 10 && chars[i] - '0' >= 8)){
                    return MIN_INT;
                }

                rev = rev * 10 + chars[i] - '0';
            }
            else{
                return plus == null || plus == true ? rev : -rev;
            }
        }
        return plus == null || plus == true ? rev : -rev;
    }
}
