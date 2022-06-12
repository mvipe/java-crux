package StackAndQueue.Stack.AdityaVerma;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int arr[]=new int[]{100,80,60,70,60,75,80};

        int res[]=stockSpan(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] stockSpan(int arr[]){
        //get the nearest greater to left
        Pair[] res2=ngl(arr);

        int res[]=new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i]=i-res2[i].index;
        }

        return res;
    }


    private static Pair[] ngl(int[] arr) {
        Stack<Pair> stack=new Stack<>();
        Pair res[]=new Pair[arr.length];
        Arrays.fill(res,new Pair(-1,-1));

        for (int i = 0; i <arr.length ; i++) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(arr[i]<stack.peek().value){
                        res[i]=stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            stack.push(new Pair(i,arr[i]));
        }

        return res;

    }

    static class Pair{
        int index;
        int value;

        Pair(int index,int value){
            this.index=index;
            this.value=value;
        }
    }
}
