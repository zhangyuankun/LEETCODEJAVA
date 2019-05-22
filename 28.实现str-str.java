/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.equals("")) return 0;
        if(needle.length()>haystack.length()) return -1;
        boolean flag = true;
        for(int i=0;i<haystack.length();i++){
            flag=true;
            for(int j=0,k=i;j<needle.length()&&k<haystack.length();j++,k++){
                if(needle.charAt(j)!=haystack.charAt(k)) {
                    flag=false;
                    break;
                }
            }
            if(i+needle.length()>haystack.length()) break;
            if(flag==true) return i;
        }
        return -1;
    }
}

