package Algo.SlidingWindow.DynamicWindowSize;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> chMap=new HashMap<>();
        int res=0;

        int i=0;
        int j=0;

        while (j<n){
            chMap.put(s.charAt(j),1+chMap.getOrDefault(s.charAt(j),0));


            boolean isUnique=chMap.size()==(j-i+1);


            //3 cases
            if(isUnique){
                res=Math.max(res,(j-i+1));
                j++;
            }else{

                while (!isUnique){
                    if(chMap.get(s.charAt(i))==1){
                        chMap.remove(s.charAt(i));
                    }else{
                        chMap.put(s.charAt(i),chMap.get(s.charAt(i))-1);
                    }
                    i++;
                    isUnique=chMap.size()==(j-i+1);
                    //window size is same as map size means all character is unique
                }
                j++;
            }
        }

        return res;
    }
}
