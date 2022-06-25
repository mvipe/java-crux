package recursion.AdityaVerma;

import java.util.ArrayList;

//problem statement- https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
public class PrintNBitBinary {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ArrayList<String>  res=solution.NBitBinary(5);
        System.out.println(res.toString());
    }
}

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here

        return NBitBinary(0,0,N,"");
    }

    private ArrayList<String> NBitBinary(int ones,int zeroes,int N,String path) {
        // code here
        if(N==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> res=new ArrayList<>();
        if(ones>zeroes){
            res.addAll(NBitBinary(ones,zeroes+1,N-1,path+"0"));
        }
        res.addAll(NBitBinary(ones+1,zeroes,N-1,path+"1"));

        return res;
    }


}
