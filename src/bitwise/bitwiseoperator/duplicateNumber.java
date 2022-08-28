package bitwise.bitwiseoperator;

//Given an array , in this array all numbers are twice times except one number , return that answer
public class duplicateNumber {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,2,4,4};
        System.out.println(find(arr));
    }

    static int find(int arr[]){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            res=res^arr[i];
        }

        return res;
    }
}
