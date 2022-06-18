package recursion.AdityaVerma;

import java.util.ArrayList;

public class SortAnArray {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(3);

        sort(list);

        System.out.println(list.toString());



    }

    private static void sort(ArrayList<Integer> list) {
        //base case
        if(list.size()==0){
            return;
        }

        //hypothesis
        int popEl=list.remove(list.size()-1);
        sort(list);

        //induction
        //insert popel at correct position
        insert(list,popEl);
    }

    private static void insert(ArrayList<Integer> list, int popEl) {
        //base case
        if(list.size()==0 || list.get(list.size()-1)<=popEl){
            list.add(popEl);
            return;
        }

        //hypothesis
        int removedEl=list.remove(list.size()-1);
        insert(list,popEl);

        //induction
        list.add(removedEl);
    }
}
