package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Logic {

    public HashMap GetCharachterCounts(String text){
        HashMap<Character, Integer> charachterCounts = new HashMap<>();

        for (char charachter : text.toCharArray()){
            charachterCounts.merge(charachter, 1, Integer :: sum);
        }

        return charachterCounts;
    }

    public PriorityQueue SortWithPriorityQueue(HashMap<Character, Integer> input){

        PriorityQueue<Node> queue = new PriorityQueue<>(input.size(), Comparator.comparingInt(o -> o.frequentie));

        for (Map.Entry<Character, Integer> entry : input.entrySet()){
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        return queue;
    }

    public Node CreateHuffmanTree(PriorityQueue<Node> input){
        while (input.size() > 1){
            Node newNode = new Node(input.poll(), input.poll());
            input.add(newNode);
        }
        return input.poll();
    }

    public HashMap<Character, EncodedChar> EncodeCharachters(Node rootNode){
        HashMap<Character, EncodedChar> allEncodedChars = new HashMap<>();
        RecursiveCreating(rootNode, new BitSet(), 0, allEncodedChars);
        return allEncodedChars;
    }

    public void RecursiveCreating(Node node, BitSet code, int counter, HashMap<Character, EncodedChar> table){
        BitSet setCopy = (BitSet) code.clone();

        if (node.leftNode != null) {
            RecursiveCreating(node.leftNode, setCopy, counter + 1, table);
        }

        if (node.rightNode != null) {
            setCopy.flip(counter);
            RecursiveCreating(node.rightNode, setCopy, counter + 1, table);
        }

        if (node.leftNode == null && node.rightNode == null) {
            table.put(node.charachter, new EncodedChar(setCopy, node.charachter, counter, node.frequentie));
        }
    }
    public EncodedString EncodeText(String input, HashMap<Character, EncodedChar> encodeTable){
        BitSet encoded = new BitSet();

        int startingLocation = 0;
        for (char charachter : input.toCharArray()){
            EncodedChar charachterCode = encodeTable.get(charachter);
            for (int i = 0; i < charachterCode.code.length(); i++){ //possible leng - 1
                if (charachterCode.code.get(i) == true) encoded.flip(i + startingLocation);
            }
            startingLocation += charachterCode.lenght;
        }

        return new EncodedString(encoded, startingLocation);
    }

    public void SaveCodingTable(HashMap<Character, EncodedChar> input) throws IOException {
        String text = "";

        for (Map.Entry<Character, EncodedChar> entry: input.entrySet()) {
            text += entry.getValue().toString() + "\r\n";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("DecodingTable.txt"));
        writer.write(text);

        writer.close();
    }

    public String DecodeText(EncodedString encodedString, HashMap<BitSet, EncodedChar> decoder){
        String decodedString = "";

        int startIndex = 0;
        for (int i = 0; i < encodedString.length + 1; i++){
            EncodedChar encoding = decoder.get(encodedString.encoding.get(startIndex, i));
            if (encoding != null){
                if (encoding.lenght == i - startIndex){
                    decodedString += encoding.symbol;
                    startIndex = i;
                }
            }
        }
        return decodedString;
    }

    public HashMap<BitSet, EncodedChar> flipHashmap(HashMap<Character, EncodedChar> input){
        HashMap<BitSet, EncodedChar> bitsetFirst = new HashMap<>();

        for (Map.Entry<Character, EncodedChar> entry: input.entrySet()) {
            bitsetFirst.put(entry.getValue().code, entry.getValue());
        }
        return bitsetFirst;
    }
}
