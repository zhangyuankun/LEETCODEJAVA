/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null) return 0;
        Integer[][] result = new Integer[grid.length][grid[0].length];
        result[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0) continue;
                else if(i==0&&j!=0){
                    result[i][j]=result[i][j-1]+grid[i][j];
                }else if(j==0){
                    result[i][j]=result[i-1][j]+grid[i][j];
                }else{
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
                }
            }
        }
        return result[grid.length-1][grid[0].length-1];
    }
}

