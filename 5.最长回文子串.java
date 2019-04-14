/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (24.60%)
 * Total Accepted:    45.9K
 * Total Submissions: 184.9K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int resultLength=1,resultb=0,resulta=0;
        boolean flag=true;
        for(int i=1;i<s.length()-1;i++){
            int b=i-1,a=i+1;
            flag=true;
            while(b>=0&&a<s.length()&&flag==true){
                if(ss[b]==ss[a]){
                    b--;
                    a++;
                }else{
                    b++;
                    a--;
                    flag=false;
                }
            }
            if(a-b+1>resultLength){
                resultb=b;
                resulta=a;
                resultLength=a-b+1;
            }
        }
        return String.copyValueOf(ss,resultb,resulta-resultb+1);
    }
}

