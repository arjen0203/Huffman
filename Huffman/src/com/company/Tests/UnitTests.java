package com.company.Tests;

import com.company.EncodedChar;
import com.company.EncodedString;
import com.company.Logic;
import com.company.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UnitTests {
    Logic logic = new Logic();

    @Test
    public void GetCHarachterCountsTest(){
        String input = "aaabbc";

        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 1);

        HashMap<Character, Integer> output = logic.GetCharachterCounts(input);

        Assert.assertEquals(expected, output);
    }
    @Test
    public void GetCHarachterCountsTest2(){
        String input = "ababacac";

        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('a', 4);
        expected.put('b', 2);
        expected.put('c', 2);

        HashMap<Character, Integer> output = logic.GetCharachterCounts(input);

        Assert.assertEquals(expected, output);
    }
    @Test
    public void GetCHarachterCountsTest3(){
        String input = "abbccbbcca";

        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 4);
        expected.put('c', 4);

        HashMap<Character, Integer> output = logic.GetCharachterCounts(input);

        Assert.assertEquals(expected, output);
    }
    @Test
    public void EncodingTest(){
        String input = "test it";

        BitSet expetedBitSet = new BitSet();
        int[] flipArr = new int[] {1, 2, 4, 5, 6, 8, 11, 13};
        for (int flip: flipArr){
            expetedBitSet.flip(flip);
        }

        EncodedString expected = new EncodedString(expetedBitSet,15);

        HashMap frequanties = logic.GetCharachterCounts(input);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);

        Node root = logic.CreateHuffmanTree(queue);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);

        EncodedString encodedText = logic.EncodeText(input, encodedChars);

        Assert.assertEquals(expected.encoding, encodedText.encoding);
        Assert.assertEquals(expected.length, encodedText.length);
    }
    @Test
    public void EncodingTest2(){
        String input = "smoll";

        BitSet expetedBitSet = new BitSet();
        int[] flipArr = new int[] {0, 1, 3, 5, 6, 7};
        for (int flip: flipArr){
            expetedBitSet.flip(flip);
        }

        EncodedString expected = new EncodedString(expetedBitSet,10);

        HashMap frequanties = logic.GetCharachterCounts(input);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);

        Node root = logic.CreateHuffmanTree(queue);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);

        EncodedString encodedText = logic.EncodeText(input, encodedChars);

        Assert.assertEquals(expected.encoding, encodedText.encoding);
        Assert.assertEquals(expected.length, encodedText.length);
    }
    @Test
    public void EncodingTest3(){
        String input = "lol lol lal lil";

        BitSet expetedBitSet = new BitSet();
        int[] flipArr = new int[] {0, 2, 4, 7, 9, 11, 14, 16, 17, 19, 22, 24, 25, 26, 27};
        for (int flip: flipArr){
            expetedBitSet.flip(flip);
        }

        EncodedString expected = new EncodedString(expetedBitSet,28);

        HashMap frequanties = logic.GetCharachterCounts(input);

        PriorityQueue queue = logic.SortWithPriorityQueue(frequanties);

        Node root = logic.CreateHuffmanTree(queue);

        HashMap<Character, EncodedChar> encodedChars = logic.EncodeCharachters(root);

        EncodedString encodedText = logic.EncodeText(input, encodedChars);

        Assert.assertEquals(expected.encoding, encodedText.encoding);
        Assert.assertEquals(expected.length, encodedText.length);
    }
}
