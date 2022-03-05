package recursion;

public class FirstIndex {
    public static void main(String[] args) {
        int arr[]={6,8,1,1,8,3,4};
        System.out.println(firstIndex(arr,0,1));

    }

    static int firstIndex(int [] arr,int ind,int target){
        if(ind==arr.length){
            return -1;
        }

        if(arr[ind]==target){
            return ind;
        }

        else{
            return firstIndex(arr,ind+1,target);
        }



    }
}
