package Tries;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_zh_CN;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomTrie {
    int numOfWords;
    private Node root;

    CustomTrie(){
        this.root=new Node('\0',false);
        this.numOfWords=0;
    }

    public int getNumOfWords(){
        return numOfWords;
    }

    public void addWord(String word){
        this.addWord(this.root,word);
    }

    private void addWord(Node parent,String word){
        if(word.length()==0){
            if(parent.isTerminal){
                //word already exixt in my libraray

            }else{
                parent.isTerminal=true;
                this.numOfWords++;
            }
            return;
        }
        char cc=word.charAt(0);
        String ros=word.substring(1);
        Node child=parent.children.get(cc);
        if(child==null){
            child=new Node(cc, false);
            parent.children.put(cc,child);
        }
        this.addWord(child,ros);
    }

    public void display(){
        this.display(this.root,"");
    }

    public void remove(String word){
        if(!search(word)) return;
        this.remove(word,this.root);
    }

    private void remove(String word,Node parent){
        if(word.length()==0 && parent.isTerminal){
            parent.isTerminal=false;
            this.numOfWords--;
            return;
        }

        HashMap<Character,Node> child=parent.children;
        Node childNode=parent.children.get(word.charAt(0));

        if(word.length()==1){
            childNode.isTerminal=false;
            this.numOfWords--;
            return;
        }

        remove(word.substring(1),childNode);

        if(!childNode.isTerminal && childNode.children.size()==0){
            parent.children.remove(word.charAt(0));
        }


    }

    public boolean search(String word){
        return this.search(word,this.root);
    }

    private boolean search(String word,Node parent){
        if(word.length()==0 && parent.isTerminal){
            return true;
        }
        if(word.length()==0 && !parent.isTerminal){
            return false;
        }

        HashMap<Character,Node> child=parent.children;
        Node childNode=parent.children.get(word.charAt(0));

        if(childNode==null) return false;
        if(word.length()==1 && childNode.isTerminal) return true;
        if(word.length()==1 && !childNode.isTerminal) return false;
        return this.search(word.substring(1),childNode);




    }

    public void display(Node parent,String word){
        if(parent==null || parent.isTerminal){
            System.out.println(word);

        }

        HashMap<Character,Node> child=parent.children;

        ArrayList<Character> childKeySet=new ArrayList<>(child.keySet());


        for(int i=0;i<childKeySet.size();i++){
            display(child.get(childKeySet.get(i)),word+childKeySet.get(i));
        }
    }



    private class Node{
        char data;
        HashMap<Character,Node> children;
        boolean isTerminal;

        Node(char data,boolean isTerminal){
            this.data=data;
            this.isTerminal=isTerminal;
            this.children=new HashMap<>();
        }
    }
}
