package array;

import java.util.Arrays;

public class sortedMatrix {
    public static void main(String[] args) {
        int [][] arr={
                {1,2,3},
                {8,9,12},
                {23,56,78}
        };

        System.out.println(Arrays.toString(search(arr,3)));


    }

    static int[] binarySearch(int [][] matrix, int row,int cStart,int cEnd,int target){
        while(cStart<=cEnd){
            int middle=cStart+(cEnd-cStart)/2;

            if(matrix[row][middle]==target){
                return new int[]{row,middle};
            }else if(matrix[row][middle]<target){
                cStart=middle+1;
            }else{
                cEnd=middle-1;
            }

        }
        return new int []{-1,-1};
    }

    static int[] search(int[][] matrix,int target){
        int rows=matrix.length;
        int cols=matrix[0].length;

        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }


        int rStart=0;
        int rEnd=rows-1;
        int cMid=cols/2;
        //run the loop till two rows are remaining

        while(rStart<(rEnd-1)){//while this is true it will have more than two row left.
            int mid=rStart+(rEnd-rStart)/2;
            if(matrix[mid][cMid]==target){
                return new int[]{mid,cMid};
            }
            if(matrix[mid][cMid]<target){
                rStart=mid;
            }else{
                rEnd=mid;
            }

        }



        //now we have two rows
        //check whether the target is in the col of two rows
        if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }

        if(matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        //search in a first Half
        if(target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }

        //search in a second Half
        if(target>=matrix[rStart][cMid+1] && target<=matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }

        //search in a 3rd Half
        if(target<=matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }

        //search in a 4th Half
        else{
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }




    }
}
