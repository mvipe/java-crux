package DynamicProgramming.AdityaVerma;

public class EqualSumPartitian {
    public static void main(String[] args) {
        int arr[]=new int []{1,5,8,5,2};
        boolean res=isEqualSumPartitian(arr);
        System.out.println(res);
    }

    private static boolean isEqualSumPartitian(int[] arr) {
        //calculate sum
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        if(sum%2!=0) return false;
        else return isSumPossibleTopDown(arr,sum%2);
    }


    private static boolean isSumPossibleTopDown(int[] arr, int sum) {
        int n=arr.length;
        //initialization
        boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;



        //choice i->
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j < n+1; j++) {
                if(arr[j-1]<=i){
                    subset[i][j] = subset[i][j - 1]
                            || subset[i - arr[j - 1]][j - 1];
                }
                else subset[i][j]=subset[i][j - 1];
            }
        }

        return subset[sum][arr.length];



    }



}
