package bitwise.bitwiseoperator;

public class countSetBits {
    public static void main(String[] args) {
        System.out.println(count(3));
    }

    static int count(int n){
        int cnt=0;

        while (n>0){
            cnt++;
            n-=(n&-n);
        }
        return cnt;
    }
}
