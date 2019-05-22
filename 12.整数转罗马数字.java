/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */
class Solution {
    public String intToRoman(int num) {
        int t = num/1000;
        int h = num%1000/100;
        int x = num%100/10;
        int s = num%10;
        String[][] rom = new String[][]{
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}};
        return rom[3][t]+rom[2][h]+rom[1][x]+rom[0][s];
    }
}

