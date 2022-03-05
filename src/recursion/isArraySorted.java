package recursion;

public class isArraySorted {
    public static void main(String[] args) {
        int[] arr={1,2,3,0,8,10};
        System.out.println(isArraySorted(arr,0));
    }

    static boolean isArraySorted(int[] arr,int i){
        if(i==arr.length-1) return true;

        if(arr[i]<arr[i+1]){
            return isArraySorted(arr,i+1);
        }


        return false;
    }
}
