package bitwise.bitwiseoperator;

public class XorTillA {
    public static void main(String[] args) {
        for (int i = 0; i <=8 ; i++) {
            System.out.println(xor_till_a(i));
        }
    }

    static int xor_till_a(int a){
        switch (a%4){
            case 0: return a;
            case 1: return 1;
            case 2: return a+1;
            case 3: return 0;

            default: return 0;
        }
    }
}
