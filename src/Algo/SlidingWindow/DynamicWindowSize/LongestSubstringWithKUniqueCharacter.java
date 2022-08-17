package Algo.SlidingWindow.DynamicWindowSize;

import java.util.HashMap;
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
//Longest Substring With K Unique Characters | Variable Size Sliding Window
public class LongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(longestkSubstr("meayl",2));
    }


    public static int longestkSubstr(String s, int k) {
        if(s.length()<k) return -1;

        int res=-1;
        HashMap<Character,Integer> chMap=new HashMap<>();

        int uniqueCh=0;

        int i=0;
        int j=0;

        while (j<s.length()){
            int val=chMap.getOrDefault(s.charAt(j),0);//prev character count
            if(val==0){
                uniqueCh++;
            }
            chMap.put(s.charAt(j),1+val);

            //3 cases
            if(uniqueCh<k){
                j++;
            }else if(uniqueCh==k){
                res=Math.max(res,(j-i+1));
                j++;
            }else if(uniqueCh>k){
                j++;
                while (uniqueCh>k){
                    int valAtI=chMap.getOrDefault(s.charAt(i),0);
                    if(valAtI==1){
                        uniqueCh--;
                    }
                    chMap.put(s.charAt(i),valAtI-1);
                    i++;
                }
            }
        }

        return res;

    }
}
