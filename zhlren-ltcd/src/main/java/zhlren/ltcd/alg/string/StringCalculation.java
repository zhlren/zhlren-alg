package zhlren.ltcd.alg.string;

import java.util.Stack;

/**
 * Created by baidu on 2017/4/15.
 */
public class StringCalculation {


    public static void main(String[] args){
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(cal(tokens));
    }

    public static int cal(String[] inputs){

        int result = 0;

        String operators = "+-*/";

        Stack<Integer> stack = new Stack<Integer>();

        for(String s : inputs){
            if(operators.contains(s)){
                int index = operators.indexOf(s);
                int a=0,b=0;
                switch (index){
                    case 0:
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a+b);
                        break;
                    case 1:
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a-b);
                        break;
                    case 2:
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a*b);
                        break;
                    case 3:
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(a/b);
                        break;
                }
            }
            else {
                stack.push(Integer.valueOf(s));
            }
        }

        return result;

    }
}
