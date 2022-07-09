package DynamicProgramming.AdityaVerma;

public class CountNumberOfSubsetWithGivenDifference {
    public static void main(String[] args) {
        int arr[]=new int[]{1,1,2,3};
        System.out.println(solveTab(arr,1));
    }

    static int solveTab(int arr[],int diff){
        //calculate sum
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        int n=arr.length;
        int tab[][]=new int[n+1][sum/2+1];
        //initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(j==0) tab[i][j]=1;
                else if(i==0) tab[i][j]=0;
            }
        }

        //code
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < tab[0].length ; j++) {
                if(arr[i-1]<=j){
                    tab[i][j] = tab[i-1][j-arr[i-1]] + tab[i-1][j];
                }

                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }

        //find the count
        int res=0;
        for (int i = 0; i < tab[0].length; i++) {
            if(sum-2*i==diff) {
                res=tab[tab.length-1][i];
            }
        }





        return tab[tab.length-1][(sum-diff)/2];




    }
}
