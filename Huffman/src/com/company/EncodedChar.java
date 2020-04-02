package com.company;

import java.util.BitSet;

public class EncodedChar {
    public BitSet code;
    public int lenght;
    public char symbol;
    public int frequentie;

    public EncodedChar(BitSet cod, char symb, int leng, int freq){
        this.code = cod;
        this.symbol = symb;
        this.lenght = leng;
        this.frequentie = freq;
    }

    @Override
    public String toString() {
        return code + "," + lenght + "," + symbol + "," + frequentie;
    }
}
