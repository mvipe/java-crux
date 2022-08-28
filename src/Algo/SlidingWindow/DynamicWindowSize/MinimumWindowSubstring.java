package Algo.SlidingWindow.DynamicWindowSize;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("A","A"));
    }

    public static String minWindow(String s, String t) {
        int i=0;
        int j=0;

        int matchedCount=0;
        HashMap<Character,Integer> chMap_t=new HashMap<>();
        for (int k = 0; k <t.length() ; k++) {
            chMap_t.put(t.charAt(k),1+chMap_t.getOrDefault(t.charAt(k),0));
        }
        int totalCharacterInT=chMap_t.size();

        String res="";
        int minSubstringLength=Integer.MAX_VALUE;

        String cur="";

        HashMap<Character,Integer> chMap_s=new HashMap<>();

        while (j<s.length()){
            cur+=s.charAt(j);
            if(chMap_t.get(s.charAt(j))!=null){
                int prev=chMap_s.getOrDefault(s.charAt(j),0);
                chMap_s.put(s.charAt(j),1+prev);
                if(chMap_s.get(s.charAt(j))==chMap_t.get(s.charAt(j))){
                    matchedCount++;
                }
            }

            //3 cases
            if(matchedCount==totalCharacterInT){//means that t is present in s substring


                while (matchedCount==totalCharacterInT){
                    if(minSubstringLength>(j-i+1)){
                        minSubstringLength=(j-i+1);
                        res=cur;
                    }
                    int previ=chMap_s.getOrDefault(s.charAt(i),0);
                    cur=cur.substring(1);
                    if(previ!=0){
                        if(previ==1){
                            chMap_s.remove(s.charAt(i));
                        }else{
                            chMap_s.put(s.charAt(i),previ-1);
                        }


                        if(previ==chMap_t.getOrDefault(s.charAt(i),0)){
                            matchedCount--;
                        }

                    }

                    i++;
                }

                j++;


            }else if(matchedCount<totalCharacterInT){
                j++;
            }
        }

        return res;
    }
}
