package DynamicProgramming.AdityaVerma.Mcm;

public class EvaluateExpressionToTrue {
    public static void main(String[] args) {
        String str="T^F&T";
        System.out.println(solveRec(str,0,str.length(),true));
    }

    static int solveRec(String s,int i,int j,boolean isTrue){
        //base case
        if(i>j) return 0;

        if(i==j){
            return isTrue==(s.charAt(i)=='T') ? 1:0;
        }

        //for loop
        int ans=0;
        for (int k = i+1; k <=j-1 ; k=k+2) {
            int lT=solveRec(s,i,k-1,true);
            int lF=solveRec(s,i,k-1,false);
            int rT=solveRec(s,k+1,j,true);
            int rF=solveRec(s,k+1,j,false);

            //calculate ans
            if(s.charAt(k)=='&'){

                ans = isTrue ? ans + lT*rT : ans + lF*rT + lT*rF + lF*rF;
            }else if(s.charAt(k)=='|'){

                ans = isTrue ? ans + lT*rT + lF*rT + lT*rF : ans + lF*rF;
            }else if(s.charAt(k)=='^'){

                ans = isTrue ? ans + lF*rT +lT*rF : ans + lT*rT + lF*rF;
            }


        }


        return ans;
    }

}
