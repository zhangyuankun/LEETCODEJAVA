import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        //BFS：
        String[][] array = {
            {},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},
            {"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}
        };
        List<String> result = new ArrayList<>();
        if(digits==null||digits.equals("")) return result;
        int a0 = Integer.parseInt(digits.charAt(0)+"");
        for(int i=0;i<array[a0].length;i++){
            result.add(array[a0][i]);
        }
        for(int i=1;i<digits.length();i++){
            int anow = Integer.parseInt(digits.charAt(i)+"");
            int size = result.size();
            for(int j=0;j<size;j++){
                String now = result.get(0);
                for(int k=0;k<array[anow].length;k++){
                    result.add(now+array[anow][k]);
                }
                result.remove(now);
            }
        }
        return result;
    }
}

