/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 *
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (28.94%)
 * Total Accepted:    4K
 * Total Submissions: 13.7K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * 示例:
 * 
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        return ((s==null||s.equals("")||s.split("\\s+").length==0)?0:((s.charAt(0)==(' '))?(s.split("\\s+").length-1):(s.split("\\s+").length)));
    }
}
