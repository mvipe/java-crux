package recursion;

public class printDI {
    public static void main(String[] args) {
        PDISkip(5);
    }

    static void PDISkip(int n){
        //n=5 -> console:5 3 1 2 4
        if(n==0) return;

        if(n%2!=0) System.out.println(n);
        PDISkip(n-1);
        if(n%2==0) System.out.println(n);

    }

    static void PDI(int n){
        if(n==0) return;

        System.out.println(n);
        PDI(n-1);
        System.out.println(n);

    }
}
