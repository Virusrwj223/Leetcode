//https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
import java.lang.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer right = numbers.pop();
                Integer left = numbers.pop();
                Integer res =  left + right;
                numbers.push(res);
            } else if (tokens[i].equals("-")) {
                Integer right = numbers.pop();
                Integer left = numbers.pop();
                Integer res =  left - right;
                numbers.push(res);
            } else if (tokens[i].equals("*")) {
                Integer right = numbers.pop();
                Integer left = numbers.pop();
                Integer res =  left * right;
                numbers.push(res);
            } else if (tokens[i].equals("/")) {
                Integer right = numbers.pop();
                Integer left = numbers.pop();
                Integer res =  left / right;
                numbers.push(res);
            } else {
                Integer num = Integer.valueOf(tokens[i]);
                numbers.push(num);
            }
        }
        return numbers.pop();
    }
}
