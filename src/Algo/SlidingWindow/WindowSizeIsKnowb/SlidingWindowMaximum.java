package Algo.SlidingWindow.WindowSizeIsKnowb;

import java.util.ArrayList;
import java.util.List;
//not solved
public class SlidingWindowMaximum {

    public static void main(String[] args) {
     List<Integer> list=new ArrayList<>();
     list.add(1);
        System.out.println(slidingMaximum(list,1));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if(A.size()<B) return new ArrayList<>();

        ArrayList<Integer> maxValues=new ArrayList<>();


        ArrayList<Integer> res=new ArrayList<>();

        int i=0;
        int j=0;



        while(j<A.size()){
            for(int m=0;m<maxValues.size();m++)
            {

                if(!maxValues.isEmpty() && maxValues.get(0)<A.get(j)){
                    maxValues.remove(0);
                }
            }

            maxValues.add(A.get(j));
            if(j-i+1==B){
                res.add(maxValues.get(0));
                if(maxValues.get(0)==A.get(i)){
                    maxValues.remove(0);
                }
                i++;
                j++;
            }else{
               j++;
            }
        }

        return res;
    }
}
