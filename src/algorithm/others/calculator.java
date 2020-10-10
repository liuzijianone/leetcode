package algorithm.others;

import com.sun.istack.internal.NotNull;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/9 9:40
 */
public class calculator {
    public static void main(String[] args) {
        String opreation = "(( 1 + 2 ) / 3 )  + 4 * ( 6 + 7 )";
        if (opreation == null || opreation.length() == 0){
            return;
        }
        System.out.println(calculate(opreation));
    }

    private static int calculate(String opreation) {
//        Stack<Integer> stack = new Stack<>();
        HashSet<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        HashSet<Character> numbers = new HashSet<>();
        for (int i = 0; i < 10 ; i++){
            numbers.add((char) ('0' + i));
        }
        StringBuilder builder = new StringBuilder(opreation);

        return helper(builder, operators, numbers);
    }


    private static  int helper(StringBuilder operation, HashSet<Character> operators, HashSet<Character> numbers){
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while(operation.length() > 0){
            char c = operation.charAt(0);
            operation.deleteCharAt(0);
            if (numbers.contains(c)){
                num = num * 10 + (c - '0');
            }
            if (c == '('){
                num = helper(operation, operators, numbers);
            }
            if(operators.contains(c) || operation.length() == 0 || c == '(' || c == ')'){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
            if(c == ')'){
                break;
            }
        }

        int count = 0;
        while (!stack.isEmpty()){
            count += stack.pop();
        }
        return count;

    }
}
