/*
 * Leetcode640题，求解方程
 * 关键字：数学、字符串、模拟
 * 主要思路：
 * 1. 主要就是模拟将左右式子化为ax + b = cx + d的形式
 * 2. x = (d - b) / (a - c)
 * 3. 如果d - b == 0 && a - c == 0，x解是无限的
 * 4. 如果d - b != 0 && a - c == 0，x是无解的
 */
class LC640 {
    public String solveEquation(String equation) {
        String[] es = equation.split("=");
        String left = es[0];
        String right = es[1];
        int[] l = merge(left);
        int[] r = merge(right);
        int up = r[1] - l[1];
        int down = l[0] - r[0];
        if(down == 0 && up == 0) return "Infinite solutions";
        if(down == 0 && up != 0) return "No solution";
        return "x=" + up / down;
    }
    public int[] merge(String s) {
        int l = 0;
        int operator = 0;
        int[] result = new int[2];
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length;i++) {
            if(i == 0 && chs[i] == '-') {
                l = 1;
                operator = 1;
                continue;
            }
            if(chs[i] == '+' || chs[i] == '-' || i == chs.length - 1) {
            if(i == chs.length - 1) i = chs.length;
            if(operator == 0) {
                if(chs[i-1] == 'x') {
                    String a = s.substring(l,i-1);
                    if(a.equals("")) {
                         result[0] += 1;
                    } else {
                         result[0] += Integer.valueOf(s.substring(l,i-1));
                    }
                   
                } else {
                    result[1] += Integer.valueOf(s.substring(l,i));
                }
                l = i + 1;
                if(i < chs.length)operator = chs[i] == '+' ? 0 : 1;
            } else if (operator == 1) {
                if(chs[i-1] == 'x') {
                    String a = s.substring(l,i-1);
                    if(a.equals("")){
                        result[0] -= 1;
                    } else {
                        result[0] -= Integer.valueOf(s.substring(l,i-1));
                    }
                } else {
                    result[1] -= Integer.valueOf(s.substring(l,i));
                }
                l = i + 1;
                if(i < chs.length) operator = chs[i] == '+' ? 0 : 1;
            }    
            
            }            
        }
        return result;
    }
}