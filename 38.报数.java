import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */
class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        else{
            String last = countAndSay(n-1);
            List<String> result = new ArrayList<>();
            int point=0;
            for(int i=0;i<last.length();i++){
                if(i==0) {
                    result.add("1");
                    result.add(String.valueOf(last.charAt(i)));
                    point+=2;
                }else{
                    if(last.charAt(i-1)==last.charAt(i)){
                        result.set((point-2),String.valueOf(Integer.valueOf(result.get((point-2)))+1));
                    }else{
                        result.add("1");
                        result.add(String.valueOf(last.charAt(i)));
                        point+=2;
                    }
                }
            }
            return String.join("", result); 
        }
    }
}

