package Practice.StackAndQueue;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(29);
        stack.push(39);
        stack.push(47);
        stack.push(12);
        System.out.println(stack.peek());
        reverse(stack,new Stack<Integer>());
        System.out.println(stack.peek());
    }

    private static void reverse(Stack<Integer> stack, Stack<Integer> helper) {





//        Stack<Integer> res=new Stack<>();
//        while(!stack.isEmpty()){
//            res.push(stack.pop());
//        }
//
//        return res;


    }
}
