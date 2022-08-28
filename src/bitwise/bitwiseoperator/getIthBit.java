package bitwise.bitwiseoperator;

public class getIthBit {
    public static void main(String[] args) {
        System.out.println(setIthBit(2,1));
    }

    static int getIthBit(int n,int i){
        return (n&(1<<(i-1)))==0?0:1;
    }

    //set the ith bit , if ith bit is 1 keep 1 , else set it to 1
    static int setIthBit(int n,int i){
        return (n|(1<<(i-1)));
    }
}
