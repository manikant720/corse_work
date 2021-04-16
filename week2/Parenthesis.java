package week2;

import java.util.*;
public class Parenthesis {
    static boolean CheckBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
            // no parenthesis on input string
            if(stack.isEmpty()) {
                return false;
            }

            char check;
            switch(x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter String to be checked : ");
        String str= sc.nextLine();
        if(CheckBalanced(str)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
