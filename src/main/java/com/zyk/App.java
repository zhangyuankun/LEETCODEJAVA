package com.zyk;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    static class Solution {
        public static int numDecodings(String s) {
            if(s==null||s.equals("")||s.charAt(0)=='0') return 0;
            else if(s.length()==1) return 1;
            else if(s.length()>1){
                if((s.charAt(0)=='1')||(s.charAt(0)=='2'&&Integer.valueOf(s.charAt(1))<=6)){
                    return numDecodings(s.substring(1))+numDecodings(s.substring(2))+1;
                }
            }
            return numDecodings(s.substring(1));
        }
    }
    public static void main(String[] args) {
        int tmin = -2147483648;
        System.out.println(tmin*(-1));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}