package DynamicProgramming.AdityaVerma;

public class SubsetSumCount {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,7,8,10};
        int sum=26;
       int res=isSumPossibleTopDown(arr,sum);
        System.out.println(res);
    }

    //topdown
    private static int isSumPossibleTopDown(int[] arr, int sum) {
        int n=arr.length;
        //initialization
        int subset[][] = new int[sum + 1][n + 1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(j==0){
                    subset[i][j]=1;
                }else if(i==0)   subset[i][j]=0;
            }
        }



        //choice i->
        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1]<=j){
                    subset[i][j] = subset[i][j - 1]
                            + subset[j - arr[i - 1]][j - 1];
                }
                else subset[i][j]=subset[i][j - 1];
            }
        }

        return subset[sum][arr.length];



    }

}
