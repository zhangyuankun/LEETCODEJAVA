/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (20.35%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 37.7K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */
class Solution {
    public int numDecodings(String s) {
        // if(s==null||s.equals("")||s.charAt(0)=='0') return 0;
        // else if(s.length()==1) return 1;
        // else if(s.equals("10")||s.equals("20")) return 1;
        // else if(s.length()==2){
        //     if(Integer.valueOf(s.charAt(0)+"")>2&&s.charAt(1)=='0') return 0;
        //     if((s.charAt(0)=='1'&&Integer.valueOf(s.charAt(1)+"")!=0)||(s.charAt(0)=='2'&&Integer.valueOf(s.charAt(1)+"")<=6&&Integer.valueOf(s.charAt(1)+"")!=0)) return 2;
        //     else return 1;
        // }
        // else if(s.length()>2){
        //     if(Integer.valueOf(s.charAt(0)+"")>2&&s.charAt(1)=='0') return 0;
        //     if((s.charAt(0)=='1')||(s.charAt(0)=='2'&&Integer.valueOf(s.charAt(1)+"")<=6)){
        //         return numDecodings(s.substring(1))+numDecodings(s.substring(2));
        //     }
        // }
        // return numDecodings(s.substring(1));
        int length = s.length();
        int[][] dp = new int[length][length];
    }
}

