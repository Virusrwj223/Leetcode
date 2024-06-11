//https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
import java.lang.*;
class Solution {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> directory = new Stack<>();
        for (int i = 0; i < pathArr.length; i++) {
            String charG = pathArr[i];
            if (charG.equals("") || charG.equals(".")) continue;
            else if (!charG.equals("..")) directory.push(charG);
            else {
                if (directory.empty()) continue;
                else directory.pop();
            }
        }
        String result = "";
        while (!directory.empty()) {
            result = "/" + directory.pop() + result; 
        }
        if (result.equals("")) return "/";
        return result;
    }
}
