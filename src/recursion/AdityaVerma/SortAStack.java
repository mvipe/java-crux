package recursion.AdityaVerma;

import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(11);
        stack.push(16);
        stack.push(9);

        sort(stack);

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void sort(Stack<Integer> stack) {
        //base case
        if(stack.isEmpty() || stack.size()==1){
            return;
        }

        //hypothesis
        int popEl=stack.pop();
        sort(stack);

        //induction
        insert(stack,popEl);
    }

    private static void insert(Stack<Integer> stack, int popEl) {
        //base case
        if(stack.isEmpty() || stack.peek()<=popEl){
            stack.push(popEl);
            return;
        }

        //hypothesis
        int removedEl=stack.pop();
        insert(stack,popEl);

        //induction
        stack.push(removedEl);



    }
}
