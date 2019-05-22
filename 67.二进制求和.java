import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */
class Solution {
    public String addBinary(String a, String b) {
        ArrayList<String> list = new ArrayList<>();
        Integer ae = 0,i=0;
        for(i=0;i<a.length()&&i<b.length();i++){
            if(a.charAt(a.length()-i-1)==b.charAt(b.length()-i-1)){
                list.add(ae.toString());
                if(a.charAt(a.length()-i-1)=='0') {
                    ae=0;
                    continue;
                }
                else ae=1;
            }else{
                if(ae==0) list.add("1");
                else{
                    list.add("0");
                }
            }
        }
        if(a.length()==b.length()&&ae==0){

        }
        else if(a.length()==b.length()&&ae==1) list.add("1");
        else {
            String left = a.length()>b.length()?a:b;
            for(;i<left.length();i++){
                if(ae==0){
                    if(left.charAt(left.length()-i-1)=='0') list.add("0");
                    else if(left.charAt(left.length()-i-1)=='1') list.add("1");
                }else{
                    if(left.charAt(left.length()-i-1)=='0') {
                        list.add("1");
                        ae=0;
                    }
                    else if(left.charAt(left.length()-i-1)=='1') {
                        list.add("0");
                    }
                }
            }
            if(ae==1) list.add("1");
        }
        for(int j=0;j<list.size()/2;j++){
            String mid = list.get(j);
            list.set(j, list.get(list.size()-j-1));
            list.set(list.size()-j-1,mid);
        }
        return String.join("", list);
    }
}

