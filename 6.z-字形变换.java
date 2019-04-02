import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (40.76%)
 * Total Accepted:    25.7K
 * Total Submissions: 62K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
*/
class Solution {
     public String convert(String s, int numRows) {
         if(numRows<2||s.length()<3) return s;
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        char[] local = s.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<local.length;i+=2*numRows-2){
            ArrayList<Character> s1 = new ArrayList<>(4);
            for(int j=0;j<numRows&&i+j<local.length;j++){
                s1.add(local[i+j]);
            }
            a.add(s1);
            for(int k=1;k<numRows-1&&i+k+numRows-1<local.length;k++){
                ArrayList<Character> s2 = new ArrayList<>();
                for(int n=0;n<numRows;n++){
                    if(n!=numRows-k-1) s2.add(null);
                    else{
                        s2.add(local[i+numRows+k-1]);
                    }
                }
                a.add(s2);
            }
        }
        for(int l=0;l<numRows;l++){
            for(int m=0;m<a.size();m++){
                if(a.get(m).size()>l&&a.get(m).get(l)!=null) result.add(a.get(m).get(l).toString());
            }
        }
        return String.join("",result);
    }
}

