package array;

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
       //Taking the input in 2d array
        int arr[][]= takeInput();
        displayData(arr);

    }

    private static void  displayData(int[][] arr){
        for (int row = 0; row < arr.length ; row++) {
            for(int col=0;col<arr[row].length;col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();

        }
    }

    private static int[][] takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of row");
        int rows=sc.nextInt();
        int arr[][] =new int[rows][];

        for (int row=0;row<rows;row++){
            System.out.println("Enter the number of columns");
            int columns=sc.nextInt();
            arr[row]=new int[columns];

            for(int col=0;col<columns;col++){
                System.out.println("Enter the value for row "+row+" and columns "+col);
                arr[row][col]=sc.nextInt();
            }
        }


        return arr;
    }
}
