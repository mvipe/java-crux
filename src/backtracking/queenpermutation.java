package backtracking;

public class queenpermutation {
    static int count=0;
    public static void main(String[] args) {
        //queenCombination(new boolean[4],0,2,"",-1);
        queenCombinationBoxRespect2d(new boolean[3][4],"",0,0,3,0);
        System.out.println(count);
    }
    static void queenCombination(boolean []boxes,int qpsf,int tq,String ans,int befInd){

        if(qpsf==tq){
            count++;
            System.out.println(ans);
            return;
        }

        for(int i=befInd+1;i<boxes.length;i++){
            if(boxes[i]==false){
                boxes[i]=true;
                queenCombination(boxes,qpsf+1,tq,ans+"q"+qpsf+"b"+i+" ",i);
                boxes[i]=false;//undo
            }
        }
    }
    static void queenCombinationBoxRespect2d(boolean [][]boxes,String ans,int row,int col,int tq,int qpsf){

        if(qpsf==tq){
            count++;
            System.out.println(ans);
            return;
        }

        if(col==boxes.length && row!=boxes[0].length){
            row=row+1;
            col=0;
        }

        if(row==boxes[0].length || col== boxes.length){
            return;
        }

        //place
        boxes[row][col]=true;
        queenCombinationBoxRespect2d(boxes,ans+"b("+row+","+col+") ",row,col+1,tq,qpsf+1);
        //not place
        boxes[row][col]=false;
        queenCombinationBoxRespect2d(boxes,ans,row,col+1,tq,qpsf);
    }
    static void queenCombinationBoxRespect2dKill(boolean [][]board,String ans,int row,int col,int tq,int qpsf){

        if(qpsf==tq){
            count++;
            System.out.println(ans);
            return;
        }

        if(col==board.length && row!=board[0].length){
            row=row+1;
            col=0;
        }

        if(row==board[0].length){
            return;
        }

        //place only if it is safe
        if(isItSafeToPlaceQUeen(board,row,col)){
            board[row][col]=true;
            queenCombinationBoxRespect2dKill(board,ans+"b("+row+","+col+") ",row,col+1,tq,qpsf+1);
            board[row][col]=false;
        }

        //not place

        queenCombinationBoxRespect2dKill(board,ans,row,col+1,tq,qpsf);
    }

    private static boolean isItSafeToPlaceQUeen(boolean[][] board, int row, int col) {
        if(row>=board.length){
            return false;
        }
        //checking for vertical up
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //checking for horizontal left

        for (int i = 0; i <col ; i++) {
            if(board[row][i]){

                return false;
            }
        }
//diagonally left
        int r=row-1;
        int c=col-1;
        while(r>=0 && c>=0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }
        //diagonally right
        r=row-1;
        c=col+1;
        while(r>=0 && c<board[0].length){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }


    static void queenCombinationBoxRespect(boolean []boxes,String ans,int col,int tq,int qpsf){

        if(qpsf==tq){
            count++;
            System.out.println(ans);
            return;
        }

        if(col==boxes.length){
            return;
        }

        //place
        boxes[col]=true;
        queenCombinationBoxRespect(boxes,ans+"b("+col,col+1,tq,qpsf+1);
        //not place
        boxes[col]=false;
        queenCombinationBoxRespect(boxes,ans,col+1,tq,qpsf);
    }

    static void queenPermutation(boolean []boxes,int qpsf,int tq,String ans){

        if(qpsf==tq){
            count++;
            System.out.println(ans);
            return;
        }

        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==false){
                boxes[i]=true;
                queenPermutation(boxes,qpsf+1,tq,ans+"q"+qpsf+"b"+i+" ");
                boxes[i]=false;//undo

            }
        }
    }
}
