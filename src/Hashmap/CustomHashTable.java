package Hashmap;

import Hashmap.Generics.LinkedList;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;

import java.util.Hashtable;

public class CustomHashTable<K,V> {
    private class HTPair{
        K key;
        V value;

        HTPair(K key,V value){
            this.key=key;
            this.value=value;
        }

        public boolean equals(Object other){
            HTPair op=(HTPair) other;//op stands for other pair
            return this.key.equals(op.key);
        }

        @Override
        public String toString(){
            return "{"+ this.key + "-" + this.value + "}";

        }
    }


    private LinkedList<HTPair>[] bucketArray;
    public static final int DEFAULT_CAPACITY=10;

    private int size;

    public CustomHashTable(){
        this(DEFAULT_CAPACITY);
    }

    public CustomHashTable(int capacity){
        this.bucketArray=(LinkedList<HTPair>[]) new LinkedList[capacity];
        this.size=0;
    }

    public void put(K key,V value){
        int bi=hashFunction(key);//bi stands for best index

        LinkedList<HTPair> bucket=this.bucketArray[bi];

        HTPair pta=new HTPair(key,value);//pta stands for pair to be added
        if(bucket==null){
            bucket=new LinkedList<>();
            bucket.insertLast(pta);
            this.bucketArray[bi]=bucket;
            this.size++;
        }else{
            int findAt=bucket.find(pta);
            if(findAt==-1){
                //it means that pta key is not found in bucket so add in last
                bucket.insertLast(pta);

                this.size++;
            }else{
                HTPair pair=bucket.get(findAt).getValue();
                pair.value=value;
            }

        }

        double lamda=(this.size*1.0)/this.bucketArray.length;
        if(lamda>0.75){
            this.rehash();
        }
    }

    private void rehash() {
        LinkedList<HTPair>[] oba=this.bucketArray;
        this.bucketArray=new LinkedList[oba.length*2];
        this.size=0;
        for(LinkedList<HTPair> ob:oba){
            while (ob!=null && !ob.isEmpty()){
                HTPair pair=ob.deleteFirst();
                this.put(pair.key,pair.value);

            }
        }


    }

    public void display(){
        for(LinkedList<HTPair> bucket:this.bucketArray){
            if(bucket!=null && !bucket.isEmpty()  ){
                bucket.display();
            }else{
                System.out.println("null");
            }
        }
    }

    public  void remove(K key){
        int bi=hashFunction(key);//bi stands for best index

        LinkedList<HTPair> bucket=this.bucketArray[bi];

        HTPair ptf=new HTPair(key,null);//ptf stands for pair to be founded
        //why value=null , because for finding we only need key
        if(bucket==null){
            System.out.println("Can't remove "+key +", key isn not founded in this hashtable");
        }else{

            int findAt=bucket.find(ptf);
            if(findAt==-1){
                System.out.println("Can't remove "+key +", key isn not founded in this hashtable");
            }else{
                if(bucket.size==1){
                    this.bucketArray[bi]=null;
                }else{
                    bucket.delete(findAt);
                }

            }


        }
    }

    public V get(K key){
        int bi=hashFunction(key);//bi stands for best index

        LinkedList<HTPair> bucket=this.bucketArray[bi];

        HTPair ptf=new HTPair(key,null);//ptf stands for pair to be founded
                                        //why value=null , because for finding we only need key
        if(bucket==null){
            return null;
        }else{
            int findAt=bucket.find(ptf);
            if(findAt==-1){
                //it means that pta key is not found in bucket so add in last
               return null;
            }else{
                HTPair pair=bucket.get(findAt).getValue();
                return pair.value;
            }


        }



    }

    private int hashFunction(K key) {
        int hc=key.hashCode();// hc stands for hash code
        hc=Math.abs(hc);// abs function gives mode value , means positive to positive and negative to positive

        int bi=hc%this.bucketArray.length;

        return bi;
    }

}
