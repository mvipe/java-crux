package DynamicProgramming.AdityaVerma.Mcm;

import java.util.HashMap;

public class ScrambledString {
    public static void main(String[] args) {
        System.out.println(solveMemo("abbbcbaaccacaacc","acaaaccabcabcbcb"));
    }

    static boolean solveMemo(String a, String b){
        HashMap<String,Boolean> mem=new HashMap<>();
        return solveMemo(a,b,mem);
    }

    static boolean solveMemo(String a,String b,HashMap<String,Boolean> mem){
        //base case
        if(a.length()!=b.length()) return false;
        if(a.compareTo(b)==0) return  true;
        if(a.length()<=1) return false;

        String key=a+"_"+b;
        if(mem.get(key)!=null) return mem.get(key);


        int n=a.length();
        boolean flag=false;//it will tell that whether string is scrambled or not

        for (int i = 1; i <=n-1; i++) {
            //case-1 - not swapped
            boolean case1=solveMemo(a.substring(0,i),b.substring(n-i,n),mem) &&
                    solveMemo(a.substring(i,n),b.substring(0,n-i),mem);

            //case-2 - not swapped
            boolean case2=solveMemo(a.substring(0,i),b.substring(0,i),mem) &&
                    solveMemo(a.substring(i,n),b.substring(i,n),mem);

            if(case1 || case2) {
                flag= true;
                break;
            }
        }

        mem.put(key,flag);
        return mem.get(key);

    }

    static boolean solveRec(String a,String b){
        //base case
        if(a.length()!=b.length()) return false;
        if(a.compareTo(b)==0) return  true;
        if(a.length()<=1) return false;


        int n=a.length();
        boolean flag=false;//it will tell that whether string is scrambled or not

        for (int i = 1; i <=n-1; i++) {
            //case-1 - not swapped
            boolean case1=solveRec(a.substring(0,i),b.substring(n-i,n)) &&
                            solveRec(a.substring(i,n),b.substring(0,n-i));

            //case-2 - not swapped
            boolean case2=solveRec(a.substring(0,i),b.substring(0,i)) &&
                            solveRec(a.substring(i,n),b.substring(i,n));

            if(case1 || case2) {
                flag= true;
                break;
            }
        }

        return flag;

    }
}
