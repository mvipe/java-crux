package bitwise.bitwiseoperator;

public class NoOfDigits {
    public static void main(String[] args) {
        System.out.println(solve(7,2));
    }

    static int solve(int n,int b){
        int ans=(int)(Math.log(n)/Math.log(b))+1;

        return ans;
    }
}
