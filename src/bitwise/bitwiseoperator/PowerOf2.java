package bitwise.bitwiseoperator;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(16));
    }

    static boolean isPowerOf2(int n){
        return (n&(n-1))==0;
    }
}
