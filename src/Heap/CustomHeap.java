package Heap;

import java.util.ArrayList;

public class CustomHeap {
    ArrayList<Integer> data=new ArrayList<>();

    public void add(int el){
        data.add(el);
        uphapify(data.size()-1);
        //why data.size()-1 : because we know that inserted data
        // will be on last index of the array list

    }

    public int delete(){
        if(data.isEmpty()) return -1;
        swap(0,this.size()-1);
        int rv=data.remove(this.size()-1);

        downheapify(0);
        return rv;
    }

    private void downheapify(int pi) {
        int leftChild=2*pi+1;
        int rightChild=2*pi+2;

        int mini=pi;

        if(leftChild<this.data.size() &&data.get(leftChild)<data.get(mini)){
            mini=leftChild;
        }
        if( rightChild<this.size() &&data.get(rightChild)<data.get(mini)){
            mini=rightChild;
        }

        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }

    public int get(){
        return this.data.get(0);
    }

    private void uphapify(int ci) {
        //ci stands for child index and pi stands for parent index
        int pi=(ci-1)/2;

        if(data.get(ci)<data.get(pi)){
            swap(ci,pi);
            uphapify(pi);
        }
    }

    private void swap(int i,int j){
        int ith=data.get(i);
        int jth=data.get(j);

        data.set(i,jth);
        data.set(j,ith);

    }

    public void display(){
        System.out.println(data);
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return this.size()==0;
    }
}
