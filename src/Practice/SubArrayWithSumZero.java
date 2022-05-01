package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//in an array is there any subarray that gives sum ZEro?
public class SubArrayWithSumZero {
    public static void main(String[] args) {
        int arr[]=new int[]{3,-5,-8,9,-1};
        System.out.println(isSumZero2(arr));
    }

    //by set
    static boolean isSumZero2(int arr[]){
        int pre=0;
        Set<Integer> set=new HashSet<>();


        for (int i = 0; i <arr.length ; i++) {
            pre=pre+arr[i];
            set.add(pre);


        }

        if(set.size()==arr.length){
            return false;
        }



        return true;
    }
    //by hashmap
    static boolean isSumZero(int arr[]){
        int pre=0;
        HashMap<Integer,Boolean> map=new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            pre=pre+arr[i];
            if(map.containsKey(pre) || pre==0){
                return true;
            }else{
                map.put(pre,true);
            }

        }



        return false;
    }
}
