package backtracking;

public class coinChange {
    public static void main(String[] args) {
        int coins[]=new int[]{2,3,5,6};
       coinChangeCoinRespect(coins,10,"",-1);
    }

    static void coinChangeCoinRespect(int coins[],int remaining,String coin,int lastInd){
        if(remaining==0){
            System.out.println(coin);
            return;
        }

        if(lastInd==coins.length-1)
        {
            return;
        }

        int curCoin=coins[lastInd+1];
        if(remaining>=curCoin){
            coinChangeCoinRespect(coins,remaining-curCoin,coin+curCoin,lastInd);
        }

        coinChangeCoinRespect(coins,remaining,coin,lastInd+1);


    }


    static void combination(int coins[],int remaining,String coin,int prev){
        if(remaining==0){
            System.out.println(coin);
            return;
        }

        for (int i = prev; i < coins.length; i++) {
            if(remaining>=coins[i]){
                combination(coins,remaining-coins[i],coin+" "+coins[i],i);
            }else{
                break;
            }

        }
    }

    static void permution(int coins[],int remaining,String coin){
        if(remaining==0){
            System.out.println(coin);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if(remaining>=coins[i]){
                permution(coins,remaining-coins[i],coin+" "+coins[i]);
            }else{
                break;
            }

        }
    }
}
