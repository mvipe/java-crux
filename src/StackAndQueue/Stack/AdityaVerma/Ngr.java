package StackAndQueue.Stack.AdityaVerma;

import java.util.Arrays;
import java.util.Stack;

public class Ngr {
    public static void main(String[] args) {
        int arr[]=new int[]{1,3,2,4};

        int res[]=ngr_bruteforce(arr);
        System.out.println(Arrays.toString(res));
        int[] res2=ngr(arr);
        System.out.println(Arrays.toString(res2));
    }

    private static int[] ngr(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        Arrays.fill(res,-1);

        for (int i = arr.length-1; i >=0 ; i--) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(arr[i]<stack.peek()){
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

    private static int[] ngr_bruteforce(int[] arr) {
        int res[]=new int[arr.length];
        Arrays.fill(res,-1);

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    res[i]=arr[j];
                    break;
                }
            }
        }


        return res;
    }
}
