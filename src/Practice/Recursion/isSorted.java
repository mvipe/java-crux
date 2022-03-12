package Practice.Recursion;
//coding block recursion practice
//Question details : Take as input N, the size of an integer array.
// Take one more input, which is a list of N integers separated by a space, and store that in an array.
// Write a recursive function which prints true if the array is sorted in Increasing Order, and false otherwise.


import java.util.Scanner;

public class isSorted {
    public static void main(String args[]) {
        // Your Code Here

        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(issorted(arr,1));


    }

    static boolean issorted(int[] arr,int i){

        if(arr.length==0){
            return true;
        }
        if(i==arr.length){
            return true;
        }

        if(arr[i]>=arr[i-1]){
            return issorted(arr,i+1);
        }else{
            return false;
        }


    }
}
