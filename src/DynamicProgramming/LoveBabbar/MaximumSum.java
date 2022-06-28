package DynamicProgramming.LoveBabbar;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
public class MaximumSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(8);
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(1);
        System.out.println(solveTab(nums));
        System.out.println(solveSO(nums));
    }

    //space optimized
    static int solveSO(ArrayList<Integer> nums){
        int last1=0;
        int last2=0;
        if(nums.size()==0) return 0;
        if(nums.size()>=1){
            last1=nums.get(nums.size()-1);
        }
        if(nums.size()>=2) {
            last2 = Math.max(nums.get(nums.size() - 1), nums.get(nums.size() - 2));
        }

        if(nums.size()<=2) return last2;

        for (int i = nums.size()-3; i >=0; i--) {
            int tempLast2=last2;
            last2=Math.max(nums.get(i)+last1,last2);
            last1=tempLast2;

        }



        return last2;
    }
    //tabulation
    static int solveTab(ArrayList<Integer> nums){
        int tab[]=new int[nums.size()+1];
        if(nums.size()==0) return 0;
        if(nums.size()>=1){
            tab[nums.size()-1]=nums.get(nums.size()-1);
        }
        if(nums.size()>=2) {
            tab[nums.size() - 2] = Math.max(nums.get(nums.size() - 1), nums.get(nums.size() - 2));
        }

        if(nums.size()<=2) return tab[0];

        for (int i = nums.size()-2; i >=0; i--) {
           tab[i]=Math.max(nums.get(i)+tab[i+2],tab[i+1]);
        }



        return tab[0];
    }


    //memo
    public static int maximumNonAdjacentSumMemo(ArrayList<Integer> nums) {
        int mem[]=new int[nums.size()+1];
        Arrays.fill(mem,-1);

        return solveRecMemo(nums,0,mem);

    }

    static int solveRecMemo(ArrayList<Integer> nums,int ind,int mem[]){
        if(ind>=nums.size()){
            //calculate sum
            return 0;
        }

        if(ind==nums.size()-1){
            return nums.get(ind);
        }

       if(mem[ind]!=-1) return mem[ind];
        //take it


        int takeIt=solveRecMemo(nums,ind+2,mem);

        //dont take it

        int dontTakeIt=solveRecMemo(nums,ind+1,mem);


        mem[ind]= Math.max(nums.get(ind)+takeIt,dontTakeIt);

        return mem[ind];
    }


    //recursion
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return solveRec2(nums,0);

    }

    static int solveRec2(ArrayList<Integer> nums,int ind){
        if(ind>=nums.size()){
            //calculate sum
            return 0;
        }

        if(ind==nums.size()-1){
            return nums.get(ind);
        }

        int sum=0;
        //take it


        int takeIt=solveRec2(nums,ind+2);

        //dont take it

        int dontTakeIt=solveRec2(nums,ind+1);


        return Math.max(nums.get(ind)+takeIt,dontTakeIt);
    }

    static int solveRec(ArrayList<Integer> subseq,ArrayList<Integer> nums,int ind){
        if(ind>=nums.size()){
            //calculate sum
            return calculateSum(subseq);
        }

        //take it
        subseq.add(nums.get(ind));

        int takeIt=solveRec(subseq,nums,ind+2);

        //dont take it
        subseq.remove(subseq.size()-1);
        int dontTakeIt=solveRec(subseq,nums,ind+1);
        return Math.max(takeIt,dontTakeIt);
    }

    private static int calculateSum(ArrayList<Integer> subseq) {
        int sum =0;
        for (int el:subseq) {
            sum+=el;
        }
        return sum;
    }


}


