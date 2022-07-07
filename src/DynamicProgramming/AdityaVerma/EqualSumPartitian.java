package DynamicProgramming.AdityaVerma;

public class EqualSumPartitian {
    public static void main(String[] args) {
        int arr[]=new int []{1,5,11,5};
        System.out.println(equalSumPartitian(arr));
        System.out.println(subsetSum(arr,11,arr.length));
    }

    static boolean equalSumPartitian(int arr[]){
        //calculate sum
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }



        if(sum%2!=0) return false;


        return subsetSum(arr,sum/2,arr.length);
    }

    private static boolean subsetSum(int[] arr, int sum,int n) {
        boolean tab[][]=new boolean[n+1][sum+1];
        //initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(j==0) tab[i][j]=true;
                else if(i==0) tab[i][j]=false;
            }
        }

        //code
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1]<=j){
                    tab[i][j] = tab[i][j-arr[i-1]] || tab[i-1][j];
                }

                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }





        return tab[n][sum];
    }

}
