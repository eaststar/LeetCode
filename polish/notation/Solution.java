/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
   Valid operators are +, -, *, /. Each operand may be an integer or another expression. 
   Some examples:
   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
package polish.notation;
import java.util.Stack;  
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)
            return 0;
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        Stack<String> stack = new Stack<String>();  
        int num = tokens.length;
        for(int i=0;i<num;i++)
        {
            int a = 0;
            int b = 0;
            if(tokens[i].equals("+"))
            {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(a+b+"");
            }
            else if(tokens[i].equals("-"))
            {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(a-b+"");
            }
            else if(tokens[i].equals("*"))
            {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(a*b+"");
            }
            else if(tokens[i].equals("/"))
            {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                if(b != 0)
                    stack.push(a/b+"");
            }
            else
            {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args)
    {
    	String[] test = {"4","3","-"};
        Solution u = new Solution();
        System.out.println("answer is " + u.evalRPN(test));
    }
}