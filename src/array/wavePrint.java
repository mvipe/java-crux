package array;

//wave print 2d Array
public class wavePrint {
    public static void main(String[] args) {
        int arr[][]=new int[][]{
                {11,12,13,14},
                {21,22,23,24},
                {31,32,33,34},
                {41,42,43,44}
        };

        //wavePrintRowWise(arr);
        spiralPrint(arr);

    }

    private static void spiralPrint(int[][] arr){
        int top=0;
        int bottom=arr.length-1;
        int left=0;
        int right=arr[top].length-1;
        int count=(bottom+1)*(right+1);
        int dir=1;


        while(left<=right && top<=bottom){
            if(count>0){
                if(dir==1){
                    for (int i = left; i <=right ; i++) {
                        System.out.print(arr[top][i]+" ");
                        count--;
                    }
                    top++;
                    if(dir>=4){
                        dir=1;
                    }else{
                        dir=dir+1;
                    }
                    System.out.println();
                }
                else if(dir==2){
                    for (int i = top; i <=bottom ; i++) {
                        System.out.print(arr[i][right]+" ");
                        count--;
                    }
                    right--;
                    if(dir>=4){
                        dir=1;
                    }else{
                        dir=dir+1;
                    }
                    System.out.println();
                }
                else if(dir==3){
                    for (int i = right; i >=left ; i--) {
                        System.out.print(arr[bottom][i]+" ");
                        count--;
                    }

                    bottom--;
                    if(dir>=4){
                        dir=1;
                    }else{
                        dir=dir+1;
                    }
                    System.out.println();

                }

                else if(dir==4){
                    for(int i=bottom;i>=top;i--){
                        System.out.print(arr[i][left]+" ");
                        count--;
                    }
                    left++;
                    if(dir>=4){
                        dir=1;
                    }else{
                        dir=dir+1;
                    }

                    System.out.println();

                }
            }
        }
    }

    private static void wavePrintRowWise(int[][] arr) {
        boolean direction=true;
        for (int i = 0; i < arr.length; i++) {
            if(direction){
                for (int j = 0; j <arr[i].length ; j++) {
                    System.out.print(arr[i][j]+" ");
                }
            }
            else{
                for (int j = arr[i].length-1; j >=0 ; j--) {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();

            direction=!direction;

        }
    }
}
