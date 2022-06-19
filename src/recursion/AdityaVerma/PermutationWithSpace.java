package recursion.AdityaVerma;

public class PermutationWithSpace {
    public static void main(String[] args) {
      permutation("","abc");
    }

    private static void permutation(String p,String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        if(up.length()>1){
            permutation(p+up.charAt(0)+" ",up.substring(1));
        }

        permutation(p+up.charAt(0),up.substring(1));
    }


}
