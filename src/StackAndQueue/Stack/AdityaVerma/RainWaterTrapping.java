package StackAndQueue.Stack.AdityaVerma;

import java.util.Arrays;
import java.util.Stack;
//Not Solved till now
public class RainWaterTrapping {
    public static void main(String[] args) {

    }

    static  int rainWaterTrapping(int arr[]){
        int maxL[]=new int[arr.length];
        int maxR[]=new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            maxL[i]=calculateMaxLeft(arr,i);
            maxR[i]=calculateMaxRight(arr,i);
        }


        return -1;

    }

    private static int calculateMaxRight(int[] arr, int ind) {
      return -1;
    }

    private static int calculateMaxLeft(int[] arr, int i) {
        return -1;
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
