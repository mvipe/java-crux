package recursion.AdityaVerma;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int n=4;
        int k=3;
        System.out.println(kth_symbol(1,1));


    }

    private static char kth_symbol(int n, int k) {
        //calculate nth grammar
        String grammar=nth_grammar(n);

        System.out.println(grammar);

        return grammar.charAt(k-1);
    }

    private static String nth_grammar(int n) {
        if(n==1) return "0";

        //hypothesis
        String grammar=nth_grammar(n-1);


        //induction
        //calculate nth grammar based on (n-1)th grammar

        return calculate_grammar(grammar);


    }

    private static String calculate_grammar(String grammar) {
        if(grammar.isEmpty()){
            return "";
        }

        if(grammar.charAt(0)=='0'){
            return "01"+calculate_grammar(grammar.substring(1));
        }

        //  if(grammar.charAt(0)=='1')
        return "10"+calculate_grammar(grammar.substring(1));

    }
}
