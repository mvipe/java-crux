package recursion;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.ArrayList;

public class subSeq {
    public static void main(String[] args) {
//        subseq("","abc");
        System.out.println(subseqret("","abc").toString());
    }

    private static void subseq(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        subseq(p,up.substring(1));
        subseq(p+up.charAt(0),up.substring(1));
    }

    private static ArrayList<String> subseqret(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList();
            list.add(p);
            return list;
        }

        ArrayList<String> res=new ArrayList<>();

        res.addAll(subseqret(p,up.substring(1)));
        res.addAll(subseqret(p+up.charAt(0),up.substring(1)));

        return res;
    }
}
