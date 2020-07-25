/*
 * @lc app=leetcode.cn id=726 lang=java
 *
 * [726] 原子的数量
 */

// @lc code=start
class Solution {

    class Element{
        String name;
        Integer amount;
    }

    public String countOfAtoms(String formula) {
        //元素后紧跟的数字代表这个元素的数量
        //括号后紧跟的数字代表这个括号内所有元素的数量都要乘以这个值
        //不同地方可能有同样的元素
        //入栈出栈
        Map<Element,Integer> map = new HashMap<>();
        Stack<Element> nowElement = new Stack<>();
        while(formula!=""){
            if(formula.startsWith("(")){
                
            }
        }
    }
}
// @lc code=end

