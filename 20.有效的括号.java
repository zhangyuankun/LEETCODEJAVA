import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                stack.add(s.charAt(i));
            }else{
                if(stack.size()==0) return false;
                switch(stack.pop()){
                    case '(':{
                        if(s.charAt(i)!=')'){
                            return false;
                        }
                        break;
                    }
                    case '[':{
                        if(s.charAt(i)!=']'){
                            return false;
                        }
                        break;
                    }
                    case '{':{
                        if(s.charAt(i)!='}'){
                            return false;
                        }
                        break;
                    }
                    default:return false;
                }
            }
        }
        if(stack.size()==0) return true;
        else return false;
    }
}

