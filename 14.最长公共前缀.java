import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        List<Character> a = new ArrayList<>();
        for(int i=0;i<strs[0].length();i++){
            char a0 = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()<i+1||strs[j].charAt(i)!=a0){
                    return a.toString().replace("[", "").replace("]", "").replace(", ", "");
                }
            }
            a.add(a0);
        }
        return a.toString().replace("[", "").replace("]", "").replace(", ", "");
    }
}

