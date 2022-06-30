package DynamicProgramming.LoveBabbar;

import java.util.Arrays;
//Not Solved
public class HouseRobber2 {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,2};

        System.out.println(houseRobberMemo(arr));


    }

    //Memo
    public static long houseRobberMemo(int[] valueInHouse){
        long mem[][]=new long[2][valueInHouse.length];
        Arrays.fill(mem[0],-1);
        Arrays.fill(mem[1],-1);
        int ind=0;

        if(valueInHouse.length%2==0){
            return houseRobberMemo(valueInHouse,ind,false,mem);
        }
        return Math.max(valueInHouse[ind]+houseRobberMemo(valueInHouse,ind+2,true,mem),
                houseRobberMemo(valueInHouse,ind+1,false,mem));

    }

    public static long houseRobberMemo(int[] valueInHouse,int ind,boolean isLastNeighbour,long mem[][]) {
        if(ind>=valueInHouse.length){
            return 0;
        }

        if(isLastNeighbour && ind==valueInHouse.length-1){
            return 0;
        }

        if(mem[isLastNeighbour?0:1][ind]!=-1){
            return mem[isLastNeighbour?0:1][ind];
        }

        mem[isLastNeighbour?0:1][ind]=Math.max(valueInHouse[ind]+houseRobberMemo(valueInHouse,ind+2,isLastNeighbour,mem),
                houseRobberMemo(valueInHouse,ind+1,isLastNeighbour,mem));

        return mem[isLastNeighbour?0:1][ind];
    }

                //recursion
    public static long houseRobber(int[] valueInHouse){
        int ind=0;

        if(valueInHouse.length%2==0){
            return houseRobber(valueInHouse,ind,false);
        }
        return Math.max(valueInHouse[ind]+houseRobber(valueInHouse,ind+2,true),
                houseRobber(valueInHouse,ind+1,false));
    }
    public static long houseRobber(int[] valueInHouse,int ind,boolean isLastNeighbour) {
        if(ind>=valueInHouse.length){
            return 0;
        }

        if(isLastNeighbour && ind==valueInHouse.length-1){
            return 0;
        }

        return Math.max(valueInHouse[ind]+houseRobber(valueInHouse,ind+2,isLastNeighbour),
                houseRobber(valueInHouse,ind+1,isLastNeighbour));
    }
}
