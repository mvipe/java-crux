package bitwise.bitwiseoperator;

public class power {
    public static void main(String[] args) {
        System.out.println(power(3,6));
    }

    static int power(int base, int n){
        int ans=1;

        while (n>0){

            if((n&1)==1) ans=ans*base;
            n=n>>1;
            base=base*base;

        }

        return ans;


    }
}
