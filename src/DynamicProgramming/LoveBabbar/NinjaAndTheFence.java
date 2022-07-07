package DynamicProgramming.LoveBabbar;

//https://www.codingninjas.com/codestudio/problems/ninja-and-the-fence_3210208?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
public class NinjaAndTheFence {
    public static void main(String[] args) {
        int n=3;
        int k=2;

        System.out.println(numberOfWays(n,k));

    }

    public static int numberOfWays(int n, int k) {
        if(n==0){
            return 1;
        }

        if(n<0) return 0;

        if(n==1) return k;

        int res=0;
        res+=numberOfWays(n-2,k)*(k-1) + numberOfWays(n-1,k)*(k-1);

        return res;
    }
}
