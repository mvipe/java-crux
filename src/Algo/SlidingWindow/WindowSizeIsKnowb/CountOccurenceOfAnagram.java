package Algo.SlidingWindow.WindowSizeIsKnowb;

import java.util.HashMap;

public class CountOccurenceOfAnagram {
    public static void main(String[] args) {
        System.out.println(search("for","forxxorfxdofr"));
    }

    static int search(String pat, String txt) {
        int res=0;
        HashMap<Character,Integer> distinctEl=new HashMap<>();

        for (int i = 0; i < pat.length(); i++) {
            distinctEl.put(pat.charAt(i),1+distinctEl.getOrDefault(pat.charAt(i),0));
        }

        int count=distinctEl.keySet().size();//no of distinct element

        int i=0;
        int j=0;
        int k=pat.length();
        while(j<txt.length()){
            if(distinctEl.containsKey(txt.charAt(j))){
                int prevVal=distinctEl.getOrDefault(txt.charAt(j),0);
                if(prevVal==1){
                    count--;
                }
                if(prevVal==0){
                    count++;
                }
                distinctEl.put(txt.charAt(j),prevVal-1);
            }

            //two cases : based on window size
            if(j-i+1==k){

                if(count==0){
                    res++;
                }
                //remove value at ith index
                if(distinctEl.containsKey(txt.charAt(i))) {
                    int valueToBeRemoved = distinctEl.getOrDefault(txt.charAt(i), 0);
                    if (valueToBeRemoved == -1) {
                        count--;
                    }
                    if (valueToBeRemoved == 0) {
                        count++;
                    }
                    distinctEl.put(txt.charAt(i), valueToBeRemoved + 1);
                }
                i++;j++;

            }else{


                j++;
            }
        }

        return res;
    }
}
