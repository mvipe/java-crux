package StackAndQueue.Queue.LoveBabbar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/queue-reversal/1

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);
        queue.add(6);


        Queue<Integer> res=revRec(queue);
        while(!queue.isEmpty()){
            System.out.println("q"+res.remove());
        }
    }

    //reverse queue using stack
    private static Queue<Integer> revUsingStack(Queue<Integer> queue) {
        Stack<Integer> stack=new Stack<>();
        //step 1 : remove element from queue one by one and insert it in stack
        while(!queue.isEmpty()){
            stack.add(queue.remove());
        }

        //step 1 : remove element from stack one by one and insert it in queue
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        return queue;
    }


    //reverse queue using recursion
    private static Queue<Integer> revRec(Queue<Integer> queue) {
        //base case
        if(queue.size()==0 || queue.size()==1){
            return queue;
        }

        //hypothesis
        int rmVal=queue.remove();
        Queue<Integer> rev=revRec(queue);

        //induction
        rev.add(rmVal);

        return rev;


    }
}
