package recursion;
/**
 *
 * *
 * * *
 * * * *   **/
public class pattern1 {
    public static void main(String[] args) {

 //print upper pattern using recursion
        pattern(4,0,0);


    }

    private static void pattern(int n,int row,int col) {
        if(row>=n){
            return;
        }
        if(col<=row){
            System.out.print(" * ");
            pattern(n,row,col+1);
        }else{
            System.out.println();
            pattern(n,row+1,0);
        }

    }
}

