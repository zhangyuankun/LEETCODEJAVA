/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==1) return ;
        int length = matrix[0].length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-i;j++){
                int mid = matrix[i][j];
                matrix[length-i-1-j][i]=matrix[length-i-1][length-i-1-j];
                matrix[length-i-1][length-i-1-j]=matrix[j][length-i-1];
                matrix[j][length-i-1]=matrix[i][j];
                matrix[length-i-1-j][i]=mid;
                // 0,0 0,2 2,2 2,0
                // 0,1 1,2 2,1 1,0
            }
        }
        return ;
    }
}

