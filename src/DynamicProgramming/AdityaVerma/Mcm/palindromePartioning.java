package DynamicProgramming.AdityaVerma.Mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class palindromePartioning {

    public static void main(String[] args) {
        String str="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(isPalindrome(str));
//        System.out.println(solveRec(str,0,str.length()-1));
        System.out.println(solveMemo(str,0,str.length()-1));
    }



    static int solveMemo(String str,int i,int j){
        int mem[][]=new int[str.length()+1][str.length()+1];
        HashMap<String,Boolean> palindrome=new HashMap<>();

        for (int k = 0; k < mem.length; k++) {
            Arrays.fill(mem[k],-1);
        }


        return solveMemo(str,i,j,mem,palindrome);
    }

    static int solveMemo(String str,int i,int j,int mem[][], HashMap<String,Boolean> palindrome){

        if(i>=j) return 0;

        //palindrome check
        if(palindrome.get(str.substring(i,j+1))==null){
            palindrome.put(str.substring(i,j+1),isPalindrome(str.substring(i,j+1)));
        }
        if(palindrome.get(str.substring(i,j+1))){
            return 0;
        }


        if(mem[i][j]!=-1) return mem[i][j];

        int min=Integer.MAX_VALUE;


        for (int k = i; k <= j-1; k++) {
            //calculate temp ans
            //int tempAns=solveMemo(str,i,k,mem,palindrome) + solveMemo(str,k+1,j,mem,palindrome) +1;


            //further optimized
            int left;
            int right;

            if(mem[i][k]!=-1){
                left=mem[i][k];
            }else{
                left=solveMemo(str,i,k,mem,palindrome);
                mem[i][k]=left;
            }

            if(mem[k+1][j]!=-1){
                right=mem[k+1][j];
            }else{
                right=solveMemo(str,k+1,j,mem,palindrome);
                mem[k+1][j]=right;
            }



            int tempAns=left+right+1;




            //compare
            if(tempAns<min){

                min=tempAns;
            }
        }

        mem[i][j]=min;

        return mem[i][j];
    }

    //using recursion
    static int solveRec(String str,int i,int j){

        if(i>=j) return 0;

        //palindrome check
        if(isPalindrome(str.substring(i,j+1))) return 0;

        int min=Integer.MAX_VALUE;

        ArrayList<String> list=new ArrayList<>();

        for (int k = i; k <= j-1; k++) {
            //calculate temp ans
            int tempAns=solveRec(str,i,k) + solveRec(str,k+1,j) +1;

            //compare
            if(tempAns<min){

                min=tempAns;
            }
        }

        return min;
    }

    static boolean isPalindrome(String str){

        int i=0;
        int j=str.length()-1;

        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }



        return true;
    }
}
