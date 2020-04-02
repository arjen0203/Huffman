package com.company.Tests;

import com.company.EncodedChar;
import com.company.EncodedString;
import com.company.Logic;
import com.company.Node;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PerformanceTest {
    Logic logic = new Logic();

    static String tenThousendWords;
    static String millionWords;

    @BeforeClass
    public static void Setup() {

        try {
            tenThousendWords = new String(Files.readAllBytes(Paths.get("C:\\Users\\arjen\\Documents\\Fontys\\S4 EFF\\WoordenApplicatie\\tenThousand.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            millionWords = new String(Files.readAllBytes(Paths.get("C:\\Users\\arjen\\Documents\\Fontys\\S4 EFF\\WoordenApplicatie\\million.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TenThousendTest() {
        HashMap frequanties = logic.GetCharachterCounts(tenThousendWords);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);

        Node root = logic.CreateHuffmanTree(queue);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);

        try {
            logic.SaveCodingTable(encodedChars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EncodedString encodedText = logic.EncodeText(tenThousendWords, encodedChars);

        HashMap<BitSet, EncodedChar> decoder = logic.flipHashmap(encodedChars);

        String decodedString = logic.DecodeText(encodedText, decoder);
    }

    @Test
    public void MillionTest(){
        HashMap frequanties = logic.GetCharachterCounts(millionWords);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);

        Node root = logic.CreateHuffmanTree(queue);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);

        try {
            logic.SaveCodingTable(encodedChars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EncodedString encodedText = logic.EncodeText(millionWords, encodedChars);

        HashMap<BitSet, EncodedChar> decoder = logic.flipHashmap(encodedChars);

        String decodedString = logic.DecodeText(encodedText, decoder);
    }

}
