package Practice.Recursion;
//coding blocks-Mike is a very passionate about sets. Lately, he is busy solving one of the problems on sets. He has to find whether if the sum of any of the non-empty subsets of the set A is zero.
import java.util.Arrays;
import java.util.Scanner;

public class subsetSum {
    public static void main(String[] args) {
        int T;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        int [][]arr=new int[T][];
        for (int i = 0; i <T ; i++) {
            int n=sc.nextInt();
            arr[i]=new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(subsetsum(new int[0],arr[i]));
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    static boolean subsetsum(int p[],int up[]){
        if(up.length<=0 ){
            if(p.length==0){
                return false;
            }
            if(isSumZero(p)){
                System.out.println(Arrays.toString(p));
                return true;
            }
            return false;
        }

        int firstElement=up[0];
        int newUP[]=Arrays.copyOfRange(up,1,up.length);

        boolean res=subsetsum(p,newUP);
        if(res){
            return true;
        }
        else{
            int newP[]=Arrays.copyOf(p,p.length+1);
            newP[newP.length-1]=firstElement;
            return subsetsum(newP,newUP);
        }

    }

    private static boolean isSumZero(int[] p) {
        int sum=0;
        for (int i = 0; i <p.length ; i++) {
            sum+=p[i];
        }

        if(sum==0){
            return true;
        }

        return false;
    }
}
