package recursion.AdityaVerma;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);



        reverse(stack);

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.size()==1 || stack.isEmpty()) return;

        int rmEl=stack.pop();
        reverse(stack);

        insert(stack,rmEl);

    }

    private static void insert(Stack<Integer> stack, int rmEl) {
        if(stack.isEmpty()){
            stack.push(rmEl);
            return;
        }

        int removedEl=stack.pop();
        insert(stack,rmEl);

        stack.push(removedEl);
    }


}
