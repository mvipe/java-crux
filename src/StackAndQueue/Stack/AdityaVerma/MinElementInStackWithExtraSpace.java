package StackAndQueue.Stack.AdityaVerma;

import java.util.Stack;

public class MinElementInStackWithExtraSpace {

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        Stack<Integer> ss=new Stack<>();

        System.out.println(getMin(ss));

        push(s,ss,18);
        System.out.println(getMin(ss));

        push(s,ss,19);
        System.out.println(getMin(ss));

        push(s,ss,15);
        System.out.println(getMin(ss));

        push(s,ss,16);
        System.out.println(getMin(ss));

        pop(s,ss);
        System.out.println(getMin(ss));

        pop(s,ss);
        System.out.println(getMin(ss));


    }

    static void push(Stack<Integer> s,Stack<Integer> ss,int val){
        s.push(val);

        if(ss.isEmpty() || ss.peek()>=val){
            ss.push(val);
        }
    }

    static void pop(Stack<Integer> s,Stack<Integer> ss){
        if(s.isEmpty()) return;
        int removeValue=s.pop();

        if(removeValue==ss.peek()){
            ss.pop();
        }
    }

    static int getMin(Stack<Integer> ss){
       return ss.isEmpty()? -1:ss.peek();
    }
}
