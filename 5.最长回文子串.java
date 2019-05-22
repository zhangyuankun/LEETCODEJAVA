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
        if(s.length()==0) return "";
        
        char[] ss = s.toCharArray();
        int resultLength=1,resultb=0,resulta=0;
        int a=0,b=0,length=0;
        for(int i=0;i<s.length();i++){
            a=i;
            b=i;
            length=0;
            if(a>0&&ss[a-1]==ss[i]) {
                a--;
                length++;
                if(length>resultLength) {
                    resulta=a;
                    resultb=b;
                    resultLength=length;
                }
                while(a>=0&&b<s.length()&&ss[a]==ss[b]){
                    length+=2;
                    if(length>resultLength) {
                        resulta=a;
                        resultb=b;
                        resultLength=length;
                    }
                    if(a>0&&b<s.length()-1&&ss[a-1]==ss[b+1]){
                        a--;
                        b++;
                        continue;
                    }
                    break;
                }
            }
            a=i;
            b=i;
            length=0;
            if(b<s.length()-1&&ss[b+1]==ss[i]) {
                b++;
                length++;
                if(length>resultLength) {
                    resulta=a;
                    resultb=b;
                    resultLength=length;
                }
                while(a>=0&&b<s.length()&&ss[a]==ss[b]){
                    length+=2;
                    if(length>resultLength) {
                        resulta=a;
                        resultb=b;
                        resultLength=length;
                    }
                    if(a>0&&b<s.length()-1&&ss[a-1]==ss[b+1]){
                        a--;
                        b++;
                        continue;
                    }
                    break;
                }
            }
            a=i;
            b=i;
            length=0;
            while(a>=0&&b<s.length()&&ss[a]==ss[b]){
                length+=2;
                if(length>resultLength) {
                    resulta=a;
                    resultb=b;
                    resultLength=length;
                }
                if(a>0&&b<s.length()-1&&ss[a-1]==ss[b+1]){
                    a--;
                    b++;
                    continue;
                }
                break;
            }
        }
        return String.copyValueOf(ss,resulta,resultb-resulta+1);
    }
}

