package DynamicProgramming.AdityaVerma;

public class SubsetSumProblem {
    int mem[][]=new int [100][100];

    public static void main(String[] args) {
        int arr[]=new int[]{2,3,7,8,10};
        int sum=26;
        boolean res=isSumPossibleTopDown(arr,sum);
        System.out.println(res);
    }

    //topdown
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

    //recursion
    private static boolean isSumPossible(int[] arr, int sum,int ind) {
        if(sum==0) return true;

        if(arr.length==ind){
            return false;
        }

        boolean bl=false;
        if(arr[ind]<=sum){
            bl=isSumPossible(arr,sum-arr[ind],ind+1);
        }

        if(bl) return true;
        else return isSumPossible(arr,sum,ind+1);

    }

    //recursion with memoization

}
