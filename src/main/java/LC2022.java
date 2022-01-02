class LC2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        int len = original.length;
        if(len != n * m){
            return new int[0][0];
        }
        for(int i = 0;i < len / n;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = original[i*n+j];
            }
        }return ans;
       
    }
}
