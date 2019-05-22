import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0) return result;
        result.add("(");
        for(int i=1;i<n*2;i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                String now = result.get(0);
                String nowLeft = now+"(";
                String nowRight = now + ")";
                Integer countLeft = now.length()-now.replace("(", "").length();
                Integer countRight = now.length()-now.replace(")", "").length();
                if(countLeft==countRight){
                    result.add(nowLeft);
                }else if(countLeft<n&&countRight<n){
                    result.add(nowLeft);
                    result.add(nowRight);
                }else if(countRight<n){
                    result.add(nowRight);
                }
                result.remove(now);
            }
        }
        return result;
    }
}

