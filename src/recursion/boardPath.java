package recursion;

import java.util.ArrayList;

//we have given an integer and a dice we need to find the all possible way to reach that integer
public class boardPath {
    public static void main(String[] args) {
        System.out.println("size"+boardpath(10,"").size());
    }

    private static ArrayList<String> boardpath(int n,String path) {
        if(n==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> res=new ArrayList<>();

        if(n>=1){
            res.addAll(boardpath(n-1,path+1));
        }
        if(n>=2){
            res.addAll(boardpath(n-2,path+2));
        }
        if(n>=3){
            res.addAll(boardpath(n-3,path+3));
        }
        if(n>=4){
            res.addAll(boardpath(n-4,path+4));
        }
        if(n>=5){
            res.addAll(boardpath(n-5,path+5));
        }
        if(n>=6){
            res.addAll(boardpath(n-6,path+6));
        }

        return res;
    }


}
