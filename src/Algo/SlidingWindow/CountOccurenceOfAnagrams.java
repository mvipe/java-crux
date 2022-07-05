package Algo.SlidingWindow;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
//not all test case passes
public class CountOccurenceOfAnagrams {
    public static void main(String[] args) {
        String str="aabaabaa";
        String pat="b";
        System.out.println(search(pat,str));
    }

   static int search(String pat, String txt) {
        //calculate count of distinct letter
       int res=0;
       HashMap<Character,Integer> distinctElement=new HashMap<>();
       for (int i = 0; i < pat.length(); i++) {
          distinctElement.put(pat.charAt(i),1+distinctElement.getOrDefault(pat.charAt(i),0));
       }


       if(pat.length()==1){

           for (int i = 0; i < txt.length(); i++) {
               if(pat.charAt(0)==txt.charAt(i)){
                   res++;
               }
           }
           return res;
       }

      int count=distinctElement.keySet().size();

       for (int i = 0; i < pat.length(); i++) {
           if(distinctElement.containsKey(txt.charAt(i))){
               int putVal=distinctElement.getOrDefault(pat.charAt(i),0)-1;
               distinctElement.put(txt.charAt(i),putVal);

               if(putVal==0){
                   count--;
               }
               if(putVal==-1){
                   count++;
               }
           }
       }

       if(count==0){
           res++;
       }


       for (int i = 1; i <=txt.length()-pat.length(); i++) {

           //calculate the ans

           //slide the window
           int putVal=distinctElement.getOrDefault(txt.charAt(i+pat.length()-1),0)-1;
           distinctElement.put(txt.charAt(i+pat.length()-1),putVal);

           if(putVal==0) count--;

           putVal=distinctElement.getOrDefault(txt.charAt(i-1),0)+1;
           distinctElement.put(txt.charAt(i-1),putVal);

           if(putVal==1) count++;


           if(count==0) res++;
       }

       return res;
    }
}
