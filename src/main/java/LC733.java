/**
 * Leetcode733题，图像渲染
 * 关键字：广度优先搜索、深度优先搜索、数组、矩阵
 * 主要思路：
 * 1. 深度优先搜索，记录访问过的节点，不要重复访问
 */
public class LC733 {
    int[] dirs = new int[]{-1,0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        trackBack(image,visited,sr,sc,color,val);
        return image;
    }
    public void trackBack(int[][] image, int[][] visited,int sr,int sc, int color,int val) {
        int m = image.length;
        int n = image[0].length;
        if(sr < 0 || sr >= m || sc < 0 || sc >= n) return;
        if(visited[sr][sc] == 1) return;
        visited[sr][sc] = 1;
        if(image[sr][sc] == val) {
            image[sr][sc] = color;
            for(int i = 0; i < dirs.length - 1; i++) {
                int x = sr + dirs[i];
                int y = sc + dirs[i+1];
                trackBack(image,visited,x,y,color,val);
            }
        }
    }
}
