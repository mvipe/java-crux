package recursion.AdityaVerma;

public class PrintSubsets {
    public static void main(String[] args) {
        print("","abc");
    }

    static void print(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        print(p+up.charAt(0),up.substring(1));
        print(p,up.substring(1));

    }
}
