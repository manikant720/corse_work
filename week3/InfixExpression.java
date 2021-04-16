package week3;

import java.util.*;
import javax.script.*;
public class InfixExpression {
    static String PRNExpression(String infix){
        String prn = "";
        Stack<Character> stk = new Stack<Character>();

        for (int i = 0; i<infix.length(); i++) {
            char x = infix.charAt(i);
            if(Character.isDigit(x)) {
                prn = prn + x;
            } else if (x == '(') {
                stk.push(x);
            } else if (x == ')') {
                while (stk.peek() != '(') {
                    prn = prn + stk.pop();
                }
                stk.pop();
                prn = prn + '*';
            } else if (x == '+') {
                stk.push(x);
            }
        }
        return prn;
    }
    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
    static int PRNEvaluate(String prn) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Stack<String> stk = new Stack<String>();
        for (int i=0;i<prn.length();i++) {
            char x = prn.charAt(i);
            if(x == '+' || x == '*') {
                String b = stk.pop();
                String a = stk.pop();
                 stk.push("(" + a + x + b + ")");
            } else {
                stk.push("" + x);
            }
        }
        System.out.println("Evaluated value : "  + engine.eval(stk.pop()));
        return 0;
    }
    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression : ");
        String infix = sc.nextLine();
        String prn = PRNExpression(infix);
        System.out.println("RPN conversion  : " + prn);
        PRNEvaluate(prn);
    }
}
