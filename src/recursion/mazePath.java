package recursion;

public class mazePath {
    public static void main(String[] args) {
        mazepath(0,0,"");
    }

    private static void mazepath(int row, int col, String path) {
        //base case
        if(row==2 && col==2){
            System.out.println(path);
            return;
        }

        if(col!=2){
            mazepath(row,col+1,path+"H");
        }

        if(row!=2){
            mazepath(row+1,col,path+"V");
        }

        
    }


}
