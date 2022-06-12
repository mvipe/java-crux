package StackAndQueue.Stack.AdityaVerma;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {
    public static void main(String[] args) {
//        int arr[]=new int[]{6,2,5,4,5,1,6};
//
//        int res=maxAreaHistogram(arr);
//        System.out.println("The maximum area of this histogram is : "+res);

        int matrix[][]=new int[][]{
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0},
        };

        System.out.println(maxAreaRectangleInBinaryMatrix(matrix));
    }

    private static int maxAreaRectangleInBinaryMatrix(int arr[][]){
        int curHist[]=new int []{arr.length};
        int maxArea[]=new int[arr.length];


        curHist=Arrays.copyOf(arr[0],arr.length);
        maxArea[0]=maxAreaHistogram(curHist);

        int max=maxArea[0];


        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]==0){
                    curHist[j]=0;
                }else{
                    curHist[j]=  curHist[j]+1;
                }
            }

            maxArea[i]=maxAreaHistogram(curHist);
            if(maxArea[i]>max){
                max=maxArea[i];
            }
        }
        System.out.println(Arrays.toString(maxArea));

        return max;


    }

    private static int maxAreaHistogram(int arr[]){
        //get the nearest greater to left and nearest greater to right
        Pair[] nsl=nsl(arr);
        Pair[] nsr=nsr(arr);


        int area[]=new int[arr.length];

        int maxArea=0;
        for (int i = 0; i < arr.length; i++) {
            area[i]=(nsr[i].index-nsl[i].index-1)*arr[i];
            if(area[i]>maxArea){
                maxArea=area[i];
            }
        }




        return maxArea;
    }


    private static Pair[] nsl(int[] arr) {
        Stack<Pair> stack=new Stack<>();
        Pair res[]=new Pair[arr.length];
        Arrays.fill(res,new Pair(-1,-1));

        for (int i = 0; i <arr.length ; i++) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(arr[i]>stack.peek().value){
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


    private static Pair[] nsr(int[] arr) {
        Stack<Pair> stack=new Stack<>();
        Pair res[]=new Pair[arr.length];
        Arrays.fill(res,new Pair(arr.length,-1));

        for (int i = arr.length-1; i >=0 ; i--) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(arr[i]>stack.peek().value){
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
