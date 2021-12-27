import java.util.LinkedList;

/**
 * Leetcode71题，简化路径
 * 关键字：栈、字符串
 * 主要思路：
 * 1. 遇到'.'不管
 * 2. 遇到'..'出栈，注意判断当前是否为空
 * 3. 遇到正常路径，则入栈
 * 4. 将最后的结果倒序输出即可
 */
public class LC71 {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] paths = path.split("/++");
        for (int i = 0; i < paths.length; i++) {
            if(paths[i].equals(".")) {
                continue;
            } else if(paths[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!paths[i].equals("")) {
                stack.addFirst(paths[i]);
            }
        }


        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            return "/";
        }
        for (int i = stack.size() - 1; i >=0; i--) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();


    }

}
