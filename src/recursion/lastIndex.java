package recursion;

public class lastIndex {


    public static void main(String[] args) {
        int arr[]={6,8,1,1,8,9,4,1};
        System.out.println(lastIndex(arr,0,1));

    }

    static int lastIndex(int [] arr,int ind,int target){
        if(ind==arr.length){
            return -1;
        }

        if(arr[ind]==target && ind==arr.length-1){
            return ind;
        }
        if(arr[ind]==target){
            int index=ind;
            int temp=lastIndex(arr,ind+1,target);
            if(temp!=-1){
                index=temp;
            }

            return index;
        }

        else{
            return lastIndex(arr,ind+1,target);
        }



    }
}

