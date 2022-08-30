package bitwise.bitwiseoperator;

public class nthMagicNumber {
    public static void main(String[] args) {
        System.out.println(solve(6));
    }

    static int solve(int n){
        int magic=0;
        int i=1;
        while (n>0){
            int lastdigit=n&1;
           magic+=(lastdigit)*Math.pow(5,i);
           i++;
           n=n>>1;
        }

        return magic;
    }
}
