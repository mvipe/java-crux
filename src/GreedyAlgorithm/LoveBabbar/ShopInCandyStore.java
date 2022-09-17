package GreedyAlgorithm.LoveBabbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1
public class ShopInCandyStore {
    public static void main(String[] args) {
        int candies[] = new int[]{3 ,2 ,1 ,4};

        System.out.println(candyStore(candies,candies.length,2));
    }

    static ArrayList<Integer> candyStore(int candies[], int N, int K){
        ArrayList<Integer> res=new ArrayList<>();

        int maxAmount=0;
        int minAmount=0;

        Arrays.sort(candies);
        int r=N;
        for (int i = 0; i <r; i++) {

            minAmount+=candies[i];
            maxAmount+=candies[N-i-1];
            r=r-K;
        }

        res.add(minAmount);
        res.add(maxAmount);

        return res;
    }
}
