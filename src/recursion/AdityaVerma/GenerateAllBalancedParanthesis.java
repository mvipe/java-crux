package recursion.AdityaVerma;

import java.util.ArrayList;

public class GenerateAllBalancedParanthesis {
    public static void main(String[] args) {
        ArrayList<String> list=generate(3,3,"");
        System.out.println(list.toString());
    }

    private static ArrayList<String> generate(int right, int left, String path) {


        if(right==0 && left==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> res=new ArrayList<>();
        if(right>0){
            res.addAll(generate(right-1,left,path+"("));
        }

        if(left-right>0){
            res.addAll(generate(right,left-1,path+")"));
        }

        return res;
    }
}
