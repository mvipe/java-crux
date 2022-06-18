package recursion.AdityaVerma;

public class KthSymbolInGrammar2 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2,2));
    }

    public static int kthGrammar(int n, int k) {

        //base case
        if(n==1 ) return 0;



        //length of (n-1)th grammar
        int length = (int) Math.pow(2,n-1);


        if(length/2>=k){
            return kthGrammar(n-1,k);
        }

        else return 1-kthGrammar(n-1,k-(length/2));

    }
}
