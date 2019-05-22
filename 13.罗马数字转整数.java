import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
class Solution {
    public int romanToInt(String s) {
        String[] rom = new String[]{
            "I","II","III","IV","V","VI","VII","VIII","IX",
            "X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
            "C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
            "M","MM","MMM"};
        Integer[] num = new Integer[]{
            1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000,2000,3000
        };
        int result = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<30;i++){
            map.put(rom[i], num[i]);
        }
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                if(s.length()>=4&&map.containsKey(s.substring(s.length()-4,s.length()))){
                    result+=map.get(s.substring(s.length()-4,s.length()));
                    s=s.substring(0,s.length()-4);
                }else if(s.length()>=3&&map.containsKey(s.substring(s.length()-3,s.length()))){
                    result+=map.get(s.substring(s.length()-3,s.length()));
                    s=s.substring(0,s.length()-3);
                }else if(s.length()>=2&&map.containsKey(s.substring(s.length()-2,s.length()))){
                    result+=map.get(s.substring(s.length()-2,s.length()));
                    s=s.substring(0,s.length()-2);
                }else if(s.length()>=1&&map.containsKey(s.substring(s.length()-1,s.length()))){
                    result+=map.get(s.substring(s.length()-1,s.length()));
                    s=s.substring(0,s.length()-1);
                }else break;
            }
        }
        return result;
    }
}

