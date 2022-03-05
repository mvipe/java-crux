package recursion;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
//        permutationPrint("","abc");
        System.out.println(permutationPrintRet("","abc").toString());
    }

    private static void permutationPrint(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String newP=p.substring(0,i)+ch+p.substring(i);
            String newUp=up.substring(1);
            permutationPrint(newP,newUp);
        }

    }

    private static ArrayList<String> permutationPrintRet(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> res=new ArrayList<>();


        char ch=up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String newP=p.substring(0,i)+ch+p.substring(i);
            String newUp=up.substring(1);
            res.addAll(permutationPrintRet(newP,newUp));
        }

        return res;

    }


}
