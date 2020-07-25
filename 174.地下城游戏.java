/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int columnLength = dungeon.length;
        int rowLength = dungeon[0].length;
        int[][] dp = new int[columnLength][rowLength];
        for (int i = columnLength-1; i >=0; i--) {
            for (int j = rowLength-1; j >=0; j--) {
                if(i==columnLength-1&&j==rowLength-1){
                    if(dungeon[columnLength-1][rowLength-1]>0) dp[columnLength-1][rowLength-1]=1;
                    else dp[columnLength-1][rowLength-1]=-dungeon[columnLength-1][rowLength-1]+1;
                }else if(i==columnLength-1){
                    if(dungeon[i][j]>0){
                        int hpnow = dp[i][j+1]-dungeon[i][j];
                        if(hpnow<=0) dp[i][j]=1;
                        else dp[i][j]=hpnow;
                    }else{
                        dp[i][j]=dp[i][j+1]-dungeon[i][j];
                    }
                }else if(j==rowLength-1){
                    if(dungeon[i][j]>0){
                        int hpnow = dp[i+1][j]-dungeon[i][j];
                        if(hpnow<=0) dp[i][j]=1;
                        else dp[i][j]=hpnow;
                    }else{
                        dp[i][j]=dp[i+1][j]-dungeon[i][j];
                    }
                }else{
                    int dpmin = Math.min(dp[i+1][j], dp[i][j+1]);
                    if(dungeon[i][j]>0){
                        int hpnow = dpmin-dungeon[i][j];
                        if(hpnow<=0) dp[i][j]=1;
                        else dp[i][j]=hpnow;
                    }else{
                        dp[i][j]=dpmin-dungeon[i][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

