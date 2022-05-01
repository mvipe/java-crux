package Hashmap;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();

        CustomHashTable<String,Integer> table=new CustomHashTable(5);
        table.put("USA",300);
        table.put("India",340);
        table.put("USA",320);
        table.put("Uk",300);
        table.put("PAK",300);
        table.put("BAN",310);
        table.put("AFG",222);
        table.display();


        System.out.println(table.get("USA"));
        System.out.println(table.get("PAK"));

        table.remove("USA");
        table.remove("PA");
        table.display();


    }
}
