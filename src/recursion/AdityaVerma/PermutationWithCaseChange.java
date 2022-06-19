package recursion.AdityaVerma;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        permutation("","ab");
    }

    static void permutation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        permutation(p+up.charAt(0),up.substring(1));
        permutation(p+(up.charAt(0)+"").toUpperCase(),up.substring(1));
    }
}
