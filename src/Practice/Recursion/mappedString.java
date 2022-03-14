package Practice.Recursion;

import java.util.HashMap;
import java.util.Scanner;

//coding block-We are given a hashmap which maps all the letters with number. Given 1 is mapped with A, 2 is mapped with B…..26 is mapped with Z. Given a number, you have to print all the possible strings.

public class mappedString {
    public static HashMap<String,String> mappedstr=new HashMap<>();

    public static void main(String[] args) {

        mappedstr.put("1","A");
        mappedstr.put("2","B");
        mappedstr.put("3","C");
        mappedstr.put("4","D");
        mappedstr.put("5","E");
        mappedstr.put("6","F");
        mappedstr.put("7","G");
        mappedstr.put("8","H");
        mappedstr.put("9","I");
        mappedstr.put("10","J");
        mappedstr.put("11","K");
        mappedstr.put("12","L");
        mappedstr.put("13","M");
        mappedstr.put("14","N");
        mappedstr.put("15","O");
        mappedstr.put("16","P");
        mappedstr.put("17","Q");
        mappedstr.put("18","R");
        mappedstr.put("19","S");
        mappedstr.put("20","T");
        mappedstr.put("21","U");
        mappedstr.put("22","V");
        mappedstr.put("23","W");
        mappedstr.put("24","X");
        mappedstr.put("25","Y");
        mappedstr.put("26","Z");

        String str;
        Scanner sc=new Scanner(System.in);
        str=sc.next();

        printstr("",str);

    }

    private static void printstr(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        printstr(p+mappedstr.get(up.substring(0,1)),up.substring(1));

        if(up.length()>=2){
            String temp=up.substring(0,2);
            if(!(Integer.parseInt(temp)>26)){
                printstr(p+mappedstr.get(temp),up.substring(2));
            }
        }


    }
}
