package Heap;

import java.util.ArrayList;

public class GenericHeap<T extends Comparable<T>> {
    ArrayList<T> data=new ArrayList<>();

    public void add(T el){
        data.add(el);
        uphapify(data.size()-1);
        //why data.size()-1 : because we know that inserted data
        // will be on last index of the array list

    }

    public T delete(){

        swap(0,this.size()-1);
        T rv=data.remove(this.size()-1);

        downheapify(0);
        return rv;
    }

    private void downheapify(int pi) {
        int leftChild=2*pi+1;
        int rightChild=2*pi+2;

        int mini=pi;

        if(leftChild<this.data.size() && isLarger(data.get(leftChild),data.get(mini))>0){
            mini=leftChild;
        }
        if( rightChild<this.size() &&  isLarger(data.get(rightChild),data.get(mini))>0){
            mini=rightChild;
        }

        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }

    public T get(){
        return this.data.get(0);
    }

    private void uphapify(int ci) {
        //ci stands for child index and pi stands for parent index
        int pi=(ci-1)/2;

        if(isLarger(data.get(ci),data.get(pi))>0){
            swap(ci,pi);
            uphapify(pi);
        }
    }

    private void swap(int i,int j){
        T ith=data.get(i);
        T jth=data.get(j);

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

    //if t is having higher priority then it return positive value
    public int isLarger(T t , T o){
        return t.compareTo(o);
    }
}
