package GreedyAlgorithm.LoveBabbar;
//https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1
public class SurviveOnIsland {
    public static void main(String[] args) {
        System.out.println(minimumDays(10,16,2));
    }

    static int minimumDays(int S, int N, int M){
        int sunday=S/7;
        int buyingDays=S-sunday;
        int totalFood=S*M;

        int ans;

        if(totalFood%N==0) ans= totalFood/N;
        else ans=totalFood/N +1;

        if(ans>buyingDays | M>N) return -1;
        else return ans;

    }
}
