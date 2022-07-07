package DynamicProgramming.AdityaVerma;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,7,8,10,15};
        int sum=15;

        int res=solveTab(arr,sum,arr.length);
        System.out.println(res);
    }

    private static int solveTab(int[] arr, int sum,int n) {
        int tab[][]=new int[n+1][sum+1];
        //initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(j==0) tab[i][j]=1;
                else if(i==0) tab[i][j]=0;
            }
        }

        //code
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1]<=j){
                    tab[i][j] = tab[i-1][j-arr[i-1]] + tab[i-1][j];
                }

                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }





        return tab[n][sum];
    }

}
