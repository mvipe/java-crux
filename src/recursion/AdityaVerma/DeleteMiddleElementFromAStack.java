package recursion.AdityaVerma;

import java.util.Stack;

public class DeleteMiddleElementFromAStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);

        delete(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }

    private static void delete(Stack<Integer> stack) {
        //middle element from stack
        int middleIndex=stack.size()/2;
        delete(stack,middleIndex);
    }

    private static void delete(Stack<Integer> stack, int middleIndex) {
        if(stack.isEmpty() ){
            return;
        }

        if(middleIndex==0){
            stack.pop();
            return;
        }

        int rmEl=stack.pop();
        delete(stack,middleIndex-1);

        stack.add(rmEl);
    }


}
