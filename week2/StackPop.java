package week2;

import java.util.*;
public class StackPop {
    public static void main(String[] args) {
        int sum = 0;
        int popCount = 0;
        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();
        // prepare stack with value
        a.push(9);
        a.push(7);
        a.push(6);
        a.push(3);
        a.push(4);

        b.push(5);
        b.push(9);
        b.push(2);
        b.push(1);

        while(sum <11){
            int apop = a.pop();
            int bpop = b.pop();
            sum = sum + apop;
            popCount++;
            if(sum>11) {
                sum = sum - apop;
                popCount--;
                break;
            }
            if(sum<11) {
                sum = sum + bpop;
                popCount++;
                if(sum>11) {
                    sum = sum - bpop;
                    popCount--;
                    break;
                }
            }
        }
        System.out.println("Maximum pop count is " + popCount);
    }
}
