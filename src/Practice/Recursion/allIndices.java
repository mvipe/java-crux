package Practice.Recursion;

import java.util.Scanner;

public class allIndices {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int m=sc.nextInt();
    }

    static int[] AllIndices(int arr[]){
        return new int[]{};
    }
}
