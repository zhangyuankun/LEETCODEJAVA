import java.util.HashMap;

import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词模式
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (37.28%)
 * Total Accepted:    5K
 * Total Submissions: 13.5K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] resultChar = pattern.toCharArray();
        boolean flag = true;
        String[] resultString =str.split(" ");
        if(resultChar.length!=resultString.length) return false;
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<resultString.length;i++){
            System.out.println(resultChar[i]+"***"+resultString[i]+"/n");
            if(map.containsKey(resultChar[i])){
                if(!map.get(resultChar[i]).equals(resultString[i])) {
                    flag=false;
                }
            }else{
                map.put(resultChar[i],resultString[i]);
            }
        }
        for(Map.Entry<Character,String>entry:map.entrySet()){
            for(Map.Entry<Character,String>entry1:map.entrySet()){
                if((!entry.getKey().equals(entry1.getKey()))&&entry.getValue().equals(entry1.getValue())) {
                    flag=false;
                }
            }
        }
        return flag;
        
    }
}

