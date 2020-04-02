package com.company;

import java.util.Map;

public class Node {
    public char charachter;
    public int frequentie;
    public Node leftNode;
    public Node rightNode;

    public Node(char charac, int freq){
        charachter = charac;
        frequentie = freq;
        leftNode = null;
        rightNode = null;
    }

    public Node(Node lNode, Node rNode){
        frequentie = lNode.frequentie + rNode.frequentie;
        this.leftNode = lNode;
        this.rightNode = rNode;
    }

    @Override
    public String toString(){
        return charachter + ":" + frequentie;
    }
}
