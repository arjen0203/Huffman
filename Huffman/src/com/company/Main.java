package com.company;

import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        String input = "this is the big test yes";

        HashMap frequanties = logic.GetCharachterCounts(input);
        System.out.println(frequanties);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);
        System.out.println(queue);

        Node root = logic.CreateHuffmanTree(queue);
        System.out.println(root);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);
        System.out.println(encodedChars);

        EncodedString encodedText = logic.EncodeText(input, encodedChars);
        System.out.println(encodedText);

        HashMap<BitSet, EncodedChar> decoder = logic.flipHashmap(encodedChars);
        System.out.println(decoder);

        String decodedString = logic.DecodeText(encodedText, decoder);
        System.out.println(decodedString);
    }
}
