/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m=obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&j==0) dp[i][j]=1;
                else if(i==0&&j!=0){
                    if(obstacleGrid[i][j]==1) {
                        dp[i][j]=0;
                    }
                    else dp[i][j]=dp[i][j-1];
                }else if(i!=0&&j==0){
                    if(obstacleGrid[i][j]==1) {
                        dp[i][j]=0;
                    }
                    else dp[i][j]=dp[i-1][j];
                }
                else dp[i][j] = (obstacleGrid[i][j]==1)?0:(((obstacleGrid[i-1][j]==1)?0:dp[i-1][j])+((obstacleGrid[i][j-1]==1)?0:dp[i][j-1]));
            }
        }  
        return dp[m-1][n-1];
    }
}

