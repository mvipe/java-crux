package StackAndQueue.Stack.AdityaVerma;

import java.util.Arrays;
import java.util.Stack;

public class Nsl {
    public static void main(String[] args) {
        int arr[]=new int[]{1,3,2,4};

        int[] res2=nsl(arr);
        System.out.println(Arrays.toString(res2));
    }

    private static int[] nsl(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        Arrays.fill(res,-1);

        for (int i = 0; i <arr.length ; i++) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(arr[i]>stack.peek()){
                        res[i]=stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            stack.push(arr[i]);
        }

        return res;

    }

}
