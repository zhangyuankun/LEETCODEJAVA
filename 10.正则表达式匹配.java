/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
class Solution {
    // dp题
    public boolean isMatch(String s, String p) {
        // boolean dp[i][j]的含义是s[0-i]与p[0-j]是否匹配
        //dp[0][0] = true;
        //p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
        //p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]
        //p.charAt(j) == '*':
            //1.p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
            //2.p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
                //dp[i][j] = dp[i][j-1]
                //dp[i][j] = dp[i-1][j]
                //dp[i][j] = dp[i][j-2]
        if(s==null||p==null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<p.length();i++){
            if(i>0&&p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)== '.'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)=='*'){
                    if(j>0&&p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else if(j>0){
                        dp[i+1][j+1] = (dp[i][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

