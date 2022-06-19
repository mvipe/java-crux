package recursion.AdityaVerma;

import java.util.ArrayList;
import java.util.List;

public class LetterClassPermutation {
    public static void main(String[] args) {
        List<String> list=permutation("","3z4");
        System.out.println(list.toString());
    }

    static List<String> permutation(String p, String up){
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }


        List<String> res=new ArrayList<>();
        boolean isDigit=Character.isDigit(up.charAt(0));
        if(isDigit){
            res.addAll(permutation(p+up.charAt(0),up.substring(1)));
        }else{
            res.addAll(permutation(p+(up.charAt(0)+"").toLowerCase(),up.substring(1)));
            res.addAll(permutation(p+(up.charAt(0)+"").toUpperCase(),up.substring(1)));
        }


        return res;

    }
}
